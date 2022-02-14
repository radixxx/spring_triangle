package hibernate.runner;

import hibernate.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class RunTestHibernateDelete {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction(); //save the created obj

            //version 1
            Employee employee = session.get(Employee.class, 5);
            session.delete(employee);

            //version 2
            session.createQuery("delete Employee " +
                    "where name = 'Name_of_bjc'").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            factory.close();
        }

    }
}
