package hibernate.hibarnate_relations.runner;


import hibernate.hibarnate_relations.relatedEntities.Detail;
import hibernate.hibarnate_relations.relatedEntities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class RunTestHibernateOne2One {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        try{

            session = factory.getCurrentSession();
            Employee employee = new Employee("Matt", "Wilson", "IT", 1900);
            Detail detail = new Detail("Budapest", "+35057515", "matt_wilson@mail.com");


            employee.setEmpDetail(detail);
            detail.setEmployee(employee);
            session.beginTransaction(); //save the created obj

            session.save(employee);

            session.getTransaction().commit(); //always need to close session !
            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }

    }
}
