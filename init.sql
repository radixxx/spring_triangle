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

# 3
CREATE TABLE my_db.children (
                                id int NOT NULL AUTO_INCREMENT,
                                name varchar(15),
                                age int,
                                PRIMARY KEY (id)
);

CREATE TABLE my_db.section (
                               id int NOT NULL AUTO_INCREMENT,
                               name varchar(15),
                               PRIMARY KEY (id)
);

CREATE TABLE my_db.child_section (
                                     child_id int NOT NULL,
                                     section_id int NOT NULL,
                                     PRIMARY KEY (child_id, section_id),
                                     FOREIGN KEY (child_id) REFERENCES my_db.children(id),
                                     FOREIGN KEY (section_id) REFERENCES my_db.section(id));