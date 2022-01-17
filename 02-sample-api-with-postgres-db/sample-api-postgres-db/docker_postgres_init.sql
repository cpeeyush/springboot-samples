CREATE TABLE users
(
    id integer NOT NULL PRIMARY KEY,
    name character varying(255) NOT NULL,
    age integer NOT NULL
);

INSERT INTO users(id, name, age) VALUES
 (1, 'John', 20),
 (2, 'Chirs', 21),
 (3, 'Jack', 22),
 (4, 'Roy', 23),
 (5, 'Joe', 24),
 (6, 'Peeyush', 24),
 (7, 'Max', 25);
