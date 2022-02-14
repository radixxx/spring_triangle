package hibernate.runner;

import hibernate.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class RunTestHibernateUpdate {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction(); //save the created obj
            Employee employee = session.get(Employee.class, 1);
            employee.setName("Alex");

            session.createQuery("update Employee set salary = 1310 " +
                    "where id = 1 and name = 'Alex'").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            factory.close();
        }

    }
}
