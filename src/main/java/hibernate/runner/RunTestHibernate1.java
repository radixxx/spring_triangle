package hibernate.runner;

import hibernate.entites.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class RunTestHibernate1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try{
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Jen", "Warson", "Sales", 800);
            session.beginTransaction(); //save the created obj
            session.save(employee); //insert to db
            //session.getTransaction().commit(); //always need to close session !


            int myId = employee.getId();
            //session = factory.getCurrentSession(); //creating new session
            //session.beginTransaction();
            Employee employee1 = session.get(Employee.class, myId);
            session.getTransaction().commit();

        } finally {
            factory.close();
        }

    }
}
