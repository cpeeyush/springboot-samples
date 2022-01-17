CREATE TABLE users
(
    user_id integer NOT NULL PRIMARY KEY,
    name character varying(255) NOT NULL,
    age integer NOT NULL
);

INSERT INTO users(user_id, name, age) VALUES
 (1, 'John', 20),
 (2, 'Chirs', 21),
 (3, 'Jack', 22),
 (4, 'Roy', 23),
 (5, 'Joe', 24),
 (6, 'Peeyush', 24),
 (7, 'Max', 25);


CREATE TABLE contacts
(
    contact_id integer NOT NULL PRIMARY KEY,
    user_id integer NOT NULL,
    phone character varying(15),
    email character varying(100),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

INSERT INTO contacts(contact_id, user_id, phone, email) VALUES
 (1, 1, '+0000000001', 'john@example.com'),
 (2, 2, '+0000000002', 'chris@example.com'),
 (3, 3, '+0000000003', 'jack@example.com'),
 (4, 4, '+0000000004', 'roy@example.com'),
 (5, 5, '+0000000005', 'joe@example.com'),
 (6, 6, '+0000000006', 'peeyush@example.com');
