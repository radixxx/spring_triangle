package hibernate.hibarnate_relation_one2one.runner;


import hibernate.hibarnate_relation_one2one.relatedEntities.Detail;
import hibernate.hibarnate_relation_one2one.relatedEntities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class RunTestHibernateDeleteDetails {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        try{

            session = factory.getCurrentSession();
            session.beginTransaction(); //save the created obj
            Detail detail = session.get(Detail.class, 5);

            session.delete(detail);

            session.getTransaction().commit(); //always need to close session !
            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }

    }
}
