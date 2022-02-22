package hibernate.hibarnate_relation_many2many.runner;


import hibernate.hibarnate_relation_many2many.entity.Child;
import hibernate.hibarnate_relation_many2many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class RunTestHibernateMany2ManyA {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();


        Session session = null;
        try{
            session = factory.getCurrentSession();

            Section session_dance  = new Section("Dance");
            Child child_Tom = new Child("Tom", 7);
            Child child_Ben = new Child(    "Ben", 6);
            Child child_Tonny = new Child("Tonny", 7);

            session.save(session_dance);

            session_dance.addChildToSection(child_Ben);
            session_dance.addChildToSection(child_Tom);
            session_dance.addChildToSection(child_Tonny);

            session.save(child_Ben);
            session.save(child_Tom);
            session.save(child_Tonny);

            session.beginTransaction(); //save the created obj

            session.getTransaction().commit(); //always need to close session !
            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }

    }
}
