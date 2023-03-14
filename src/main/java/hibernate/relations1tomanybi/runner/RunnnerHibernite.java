package hibernate.relations1tomanybi.runner;

import hibernate.relations1to1.entity.Detail;
import hibernate.relations1tomanybi.entity.Employee;
import hibernate.relations1tomanybi.entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunnnerHibernite {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {
            var department = new Department("Testing", "10000", "1500");
            var employee = new Employee("Dan", "Kiki", "4000");
            var employee1 = new Employee("Olga", "Tomphson", "2000");

            department.addEmployeeToDepartment(employee);
            department.addEmployeeToDepartment(employee1);

            session.beginTransaction();
            session.save(department);
            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
