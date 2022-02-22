package hibernate.hibarnate_relation_many2many.runner;


import hibernate.hibarnate_relation_many2many.entity.Child;
import hibernate.hibarnate_relation_many2many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class RunTestHibernateMany2ManyGet {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;
        try{
            session = factory.getCurrentSession();
            session.beginTransaction(); //save the created obj

            Section section = session.get(Section.class, 1);

            System.out.println(section);
            System.out.println(section.getChildList());


            Child child = session.get(Child.class, 4);
            System.out.println(child);
            System.out.println(child.getSectionList());


            session.getTransaction().commit(); //always need to close session !
            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }

    }
}
