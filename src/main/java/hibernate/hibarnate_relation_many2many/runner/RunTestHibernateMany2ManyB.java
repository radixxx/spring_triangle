package hibernate.hibarnate_relation_many2many.runner;


import hibernate.hibarnate_relation_many2many.entity.Child;
import hibernate.hibarnate_relation_many2many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class RunTestHibernateMany2ManyB {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();


        Session session = null;
        try{
            session = factory.getCurrentSession();

            Child child_Skip = new Child("Skip", 6);
            Section section_swimming =  new Section("Swimming");
            Section section_football =  new Section("Football");
            Section section_basketball =  new Section("Basketball");

            child_Skip.addSectionToChild(section_swimming);
            child_Skip.addSectionToChild(section_football);
            child_Skip.addSectionToChild(section_basketball);

            session.beginTransaction(); //save the created obj

            session.save(child_Skip);

            session.getTransaction().commit(); //always need to close session !
            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }

    }
}
