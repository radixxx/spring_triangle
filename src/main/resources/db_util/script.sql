/*run from mac os terminal
mysql -uroot
DB: my_db
User: bestuser

https://flaviocopes.com/mysql-how-to-install/
brew services start mysql
brew services stop mysql
*/

CREATE TABLE my_db.details (
                               id int NOT NULL AUTO_INCREMENT,
                               city varchar(15),
                               phone_number varchar(25),
                               email varchar(30), PRIMARY KEY (id)
);

CREATE TABLE my_db.employees (
                                 id int NOT NULL AUTO_INCREMENT,
                                 name varchar(15),
                                 surname varchar(25),
                                 department varchar(20), salary int, details_id int
    ,  PRIMARY KEY (id)
    , FOREIGN KEY (details_id) REFERENCES my_db.details(id));



CREATE TABLE my_db.departments (
                                   id int NOT NULL AUTO_INCREMENT,
                                   name varchar(15),
                                   max_salary int,
                                   min_salary int,
                                   PRIMARY KEY (id)
);

CREATE TABLE my_db.employees_office (
                                        id int NOT NULL AUTO_INCREMENT,
                                        name varchar(15),
                                        surname varchar(25),
                                        salary int,
                                        department_id int,
                                        PRIMARY KEY (id),
                                        FOREIGN KEY (department_id) REFERENCES my_db.departments(id));


SHOW tables;

select * from my_db.details;
select * from my_db.employees;
select * from my_db.departments;
select * from my_db.child_section;
select * from my_db.section;
select * from my_db.child_section;


#JOIN !
select * from my_db.employees_office
                  join departments d on d.id = employees_office.department_id;

drop table my_db.employees;
drop table my_db.details;


#Many 2 Many
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
