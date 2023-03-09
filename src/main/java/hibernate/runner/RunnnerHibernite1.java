package hibernate.runner;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunnnerHibernite1 {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            Employee employee = new Employee("Tom", "Datt", "IT",  2000);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
            //session.getTransaction().rollback();
        } finally {
            sessionFactory.close();
        }
    }
}
