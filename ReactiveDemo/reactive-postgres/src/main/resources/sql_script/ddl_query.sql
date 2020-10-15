create table employee
(
    id int NOT NULL AUTO_INCREMENT,
    firstName varchar(50) null,
    lastName varchar(50) null,
    age int null,
    martialStatus varchar(20),
    PRIMARY KEY (id)
);

-- Postgres query

create table employee
(
    id SERIAL PRIMARY KEY,
    firstName varchar(50) null,
    lastName varchar(50) null,
    age int null,
    martialStatus varchar(20)
);
