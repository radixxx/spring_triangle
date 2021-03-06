package hibernate.runner;

import hibernate.entites.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class RunTestHibernate {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try{
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Kenn", "Ronski", "Sales", 1950);

            session.beginTransaction(); //save the created obj
            session.save(employee); //insert

            session.getTransaction().commit(); //always need to close session !

            System.out.println("Done");
        } finally {
            factory.close();
        }

    }
}
