package hibernate.hibarnate_relation_one2many_bi.entitesOne2Many.runner;


import hibernate.hibarnate_relation_one2many_bi.entitesOne2Many.entities.Department;
import hibernate.hibarnate_relation_one2many_bi.entitesOne2Many.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class RunTestHibernateOne2Many {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try{
            session = factory.getCurrentSession();

            Department department = new Department("IT", 1300, 1900);
            Employee employee1 = new Employee("Tom", "Datt", 1590);
            Employee employee2 = new Employee("Kent", "Block", 1890);
            Employee employee3 = new Employee("Kent", "Block", 1890);

            department.addEmployeeToDepartment(employee1);
            department.addEmployeeToDepartment(employee2);

            session.beginTransaction();
            session.save(department);


            session.getTransaction().commit(); //always need to close session !
            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }

    }
}
