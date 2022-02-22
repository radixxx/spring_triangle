package hibernate.hibarnate_relation_many2many.runner;


import hibernate.hibarnate_relation_many2many.entity.Child;
import hibernate.hibarnate_relation_many2many.entity.Section;
import hibernate.hibarnate_relation_one2one.relatedEntities.Detail;
import hibernate.hibarnate_relation_one2one.relatedEntities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class RunTestHibernateMany2ManyDelete {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Session.class)
                .buildSessionFactory();

        Session session = null;
        try{

            session = factory.getCurrentSession();
            session.beginTransaction(); //save the created obj
            Section section = session.get(Section.class, 3);

            session.delete(section);

            session.getTransaction().commit(); //always need to close session !
            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }

    }
}
