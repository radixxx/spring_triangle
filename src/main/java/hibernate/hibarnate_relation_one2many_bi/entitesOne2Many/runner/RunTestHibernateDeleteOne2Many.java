package hibernate.hibarnate_relation_one2many_bi.entitesOne2Many.runner;


import hibernate.hibarnate_relation_one2many_bi.entitesOne2Many.entities.Department;
import hibernate.hibarnate_relation_one2many_bi.entitesOne2Many.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class RunTestHibernateDeleteOne2Many {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try{
            session = factory.getCurrentSession();

            session.beginTransaction();
            Employee employee = session.get(Employee.class, 3);
            Department department = session.get(Department.class, 2);

            session.delete(employee);
            session.delete(department);

            session.getTransaction().commit(); //always need to close session !
            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }

    }
}
