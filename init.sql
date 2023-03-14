CREATE DATABASE my_db;
SELECT session_user, current_database();

CREATE TABLE employees (
  id int NOT NULL,
  name varchar(15),
  surname varchar(25),
  department varchar(20),
  salary int,
  PRIMARY KEY (id)
);

CREATE TABLE details (
    id           int NOT NULL,
    city         varchar(15),
    phone_number varchar(25),
    email        varchar(30),
    PRIMARY KEY (id)
);

# second part of script
CREATE TABLE my_db.departments (
                                   id int NOT NULL AUTO_INCREMENT,
                                   name varchar(15),
                                   max_salary int,
                                   min_salary int,
                                   PRIMARY KEY (id)
);

CREATE TABLE my_db.employeess (
                                 id int NOT NULL AUTO_INCREMENT,
                                 name varchar(15),
                                 surname varchar(25),
                                 salary int,
                                 department_id int,
                                 PRIMARY KEY (id),
                                 FOREIGN KEY (department_id) REFERENCES my_db.departments(id));