package com.alexchulkin.vaadin;

/**
 * Created by alexc_000 on 2016-12-25.
 */

import com.alexchulkin.dto.EmpDto;
import com.alexchulkin.dto.TktDto;
import com.alexchulkin.rs.EmpRSClient;
import com.alexchulkin.ws.EmpWSClient;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

import javax.servlet.annotation.WebServlet;
import java.text.DateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static java.util.Locale.ITALIAN;
import static java.util.TimeZone.SHORT;

//import com.alexchulkin.rs.EmpRSClient;
//import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
//import org.jboss.resteasy.plugins.providers.jackson.ResteasyJackson2Provider;
//import org.jboss.resteasy.spi.ResteasyProviderFactory;

@SuppressWarnings("serial")
@Theme("vaadin_ws_rs")
public class VaadinWSRSUI extends UI {
    private static Window previousWindow;

    @Override
    protected void init(VaadinRequest request) {
        final EmpRSClient empRSClient = new EmpRSClient();
        final EmpWSClient empWsClient = new EmpWSClient();

        TableConstructor tableConstructor = new TableConstructor();
        Table mainTable = tableConstructor.getMainTable(empWsClient);
        setContent(mainTable);

        mainTable.addItemClickListener((ItemClickEvent itemClickEvent) -> {
            if (previousWindow!= null) {
                getUI().removeWindow(previousWindow);
            }
            Table supplTable = tableConstructor.getSupplementaryTable(empRSClient, ((EmpDto) itemClickEvent.getItemId()).getId());
            previousWindow = new Window();
            previousWindow.setContent(supplTable);
            previousWindow.setModal(true);
            getUI().addWindow(previousWindow);
        });
    }

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = VaadinWSRSUI.class)
    public static class Servlet extends VaadinServlet {
    }

    private static class TableConstructor {
        private static final DateFormat format = DateFormat.getDateInstance(SHORT, ITALIAN);
        private static int number = 0;
        private Table.ColumnGenerator dateColumnGenerator = (Table source, Object itemId, Object columnId) -> {
            Item item = source.getItem(itemId);
            @SuppressWarnings("unchecked")
            Property<Date> property = (Property<Date>) item.getItemProperty(columnId);
            Date value = property.getValue();
            return format.format(value);
        };
        private Table.ColumnGenerator simpleColumnGenerator = (Table source, Object itemId, Object columnId) -> {
            return source.getItem(itemId).getItemProperty(columnId).getValue().toString();
        };

        public Table getMainTable(EmpWSClient empWsClient) {
            BeanItemContainer<EmpDto> container = new BeanItemContainer<>(EmpDto.class);
            System.out.println(empWsClient.listAllEmps());
            container.addAll(empWsClient.listAllEmps());

            Table table = new Table("All employees", container);
            table.addGeneratedColumn("id", simpleColumnGenerator);
            table.addGeneratedColumn("serialNumber", simpleColumnGenerator);
            table.addGeneratedColumn("fullName", simpleColumnGenerator);
            table.addGeneratedColumn("hiredDate", dateColumnGenerator);
            table.addGeneratedColumn("numberOfClosedTickets", simpleColumnGenerator);
            table.setVisibleColumns("id", "serialNumber", "fullName", "hiredDate", "numberOfClosedTkts");
            table.setColumnWidth("id", 200);
            table.setColumnWidth("serialNumber", 200);
            table.setColumnWidth("fullName", 200);
            table.setColumnWidth("hiredDate", 200);
            table.setColumnWidth("numberOfClosedTkts", 200);
            table.setColumnHeaders("Id", "Serial Number", "Full Name", "Hired date", "Number of closed tickets");
            table.setRowHeaderMode(Table.RowHeaderMode.PROPERTY);
            table.setItemCaptionPropertyId("displayName");
            return table;

        }

        public Table getSupplementaryTable(EmpRSClient empRSClient, Long id) {

            BeanItemContainer<TktDto> container = new BeanItemContainer<>(TktDto.class);
            try {
                List<TktDto> tktsList = empRSClient.getEmpTktsXML(id);
                container.addAll(tktsList);
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }

            Table table = new Table("Employee's tickets", container);
            table.addGeneratedColumn("id", simpleColumnGenerator);
            table.addGeneratedColumn("parentTicketId", simpleColumnGenerator);
            table.addGeneratedColumn("code", simpleColumnGenerator);
            table.addGeneratedColumn("description", simpleColumnGenerator);
            table.setVisibleColumns("id", "parentTicketId", "code", "description");
//            table.setColumnHeaders("Id", "Parent ticket id", "Code", "Description");
            table.setColumnHeaders(Collections.nCopies(4, "").toArray(new String[0]));
            table.setColumnWidth("id", 100);
            table.setColumnWidth("parentTicketId", 200);
            table.setColumnWidth("code", 200);
            table.setColumnWidth("description", 400);
            table.setRowHeaderMode(Table.RowHeaderMode.PROPERTY);
            table.setItemCaptionPropertyId("displayName");
            return table;
        }
    }
}

