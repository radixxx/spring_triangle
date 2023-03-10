package hibernate.dml.runner;

import hibernate.dml.entity.Employee;
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
            Employee employee = new Employee("Jef", "Bond", "HR",  400);
            session.beginTransaction();
            session.save(employee);
            //session.getTransaction().rollback();

            int id = employee.getId();
            Employee emp = session.get(Employee.class, id);
            session.getTransaction().commit();
            System.out.println("From DB: " + emp);

        } finally {
            sessionFactory.close();
        }
    }
}
