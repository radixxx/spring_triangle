package hibernate.relations1to1.runner;

import hibernate.relations1to1.entity.Detail;
import hibernate.relations1to1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunnnerHibernite {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {
            Employee employee = new Employee("Gleb", "Swarowski", "DEV", 1790);
            Detail detail = new Detail("Chisinau",  "37907062", "test.gleb@mail.com");
            employee.setEmpDetail(detail);
            session.beginTransaction();
           /* Employee employee = session.get(Employee.class, 9);
            session.delete(employee);*/
            session.save(employee);
            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
