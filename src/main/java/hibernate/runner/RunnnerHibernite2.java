package hibernate.runner;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnnerHibernite2 {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            List<Employee> employeeList = session.createQuery("from Employee")
                            .getResultList();

            for (Employee e : employeeList) {
                System.out.println(e);
            }

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
