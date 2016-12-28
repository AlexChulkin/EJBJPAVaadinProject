INSERT INTO ticket (parent_ticket_id, code, description) VALUES (null, 't01-19', 'fix the major bug');
INSERT INTO ticket (parent_ticket_id, code, description) VALUES (null, 't01-20', 'implement the new ui');
INSERT INTO ticket (parent_ticket_id, code, description) VALUES (1, 't02-11', 'fix the minor bug #1');
INSERT INTO ticket (parent_ticket_id, code, description) VALUES (1, 't02-13', 'fix the minor bug #2');
INSERT INTO ticket (parent_ticket_id, code, description) VALUES (null, 't07-02', 'add the major functionality');
INSERT INTO ticket (parent_ticket_id, code, description) VALUES (6, 't07-03', 'add the minor functionality #1');
INSERT INTO ticket (parent_ticket_id, code, description) VALUES (7, 't07-04', 'add the minor functionality #2');
INSERT INTO ticket (parent_ticket_id, code, description) VALUES (null, 't08-01', 'refactoring');

INSERT INTO employee (name, last_name, hired_date) VALUES ('bob', 'marley', '1961-09-19');
INSERT INTO employee (name, last_name, hired_date) VALUES ('elvis', 'presley', '1952-03-11');
INSERT INTO employee (name, last_name, hired_date) VALUES ('till', 'lindemann', '1971-10-10');

INSERT INTO assigned_tickets (employee_id, ticket_id, status, assigned_date, resolved_date, closed_date)
VALUES (1, 1, 'OPENED', '2016-12-12 10:10:11', NULL, NULL);
INSERT INTO assigned_tickets (employee_id, ticket_id, status, assigned_date, resolved_date, closed_date)
VALUES (1, 3, 'OPENED', '2016-12-13 10:10:12', NULL, NULL);
INSERT INTO assigned_tickets (employee_id, ticket_id, status, assigned_date, resolved_date, closed_date)
VALUES (1, 4, 'RESOLVED', '2016-12-13 11:00:00', '2016-12-13 14:13:00', NULL);
INSERT INTO assigned_tickets (employee_id, ticket_id, status, assigned_date, resolved_date, closed_date)
VALUES (2, 2, 'OPENED', '2016-12-12 10:00:03', NULL, NULL);
INSERT INTO assigned_tickets (employee_id, ticket_id, status, assigned_date, resolved_date, closed_date)
VALUES (3, 5, 'OPENED', '2016-12-12 10:00:05', NULL, NULL);
INSERT INTO assigned_tickets (employee_id, ticket_id, status, assigned_date, resolved_date, closed_date)
VALUES (3, 6, 'CLOSED', '2016-12-12 10:00:05', '2016-12-12 17:20:10', '2016-12-12 17:20:13');
INSERT INTO assigned_tickets (employee_id, ticket_id, status, assigned_date, resolved_date, closed_date)
VALUES (3, 7, 'RESOLVED', '2016-12-12 10:00:30', '2016-12-13 11:12:01', NULL);
INSERT INTO assigned_tickets (employee_id, ticket_id, status, assigned_date, resolved_date, closed_date)
VALUES (3, 8, 'OPENED', '2016-12-12 13:00:30', NULL, NULL);
