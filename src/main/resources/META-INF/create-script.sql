CREATE TABLE employee (
 id SERIAL PRIMARY KEY,
 name varchar NOT NULL ,
 last_name varchar NOT NULL ,
 hired_date date
);
CREATE TABLE ticket (
 id SERIAL PRIMARY KEY,
 parent_ticket_id bigint REFERENCES ticket (id),
 code varchar,
 description varchar
);

CREATE TYPE ticket_status AS ENUM ('OPENED', 'RESOLVED', 'CLOSED');

CREATE TABLE assigned_tickets (
 id SERIAL PRIMARY KEY,
 employee_id bigint REFERENCES employee (id) NOT NULL ,
 ticket_id bigint REFERENCES ticket (id) NOT NULL ,
 status ticket_status,
 assigned_date timestamp,
 resolved_date timestamp,
 closed_date timestamp,
 UNIQUE (employee_id, ticket_id)
);
