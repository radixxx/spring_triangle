package hibernate.runner;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnnerHibernite3 {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Employee set salary=1333" +
                    "where name = 'Tom'").executeUpdate();

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
