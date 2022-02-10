package hibernate;

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
            Employee employee = new Employee("Tom", "Dat", "IT", 850);

            session.beginTransaction(); //save the created obj
            session.save(employee); //insert

            session.getTransaction().commit(); //always need to close session !
        } finally {
            factory.close();
        }

    }
}
