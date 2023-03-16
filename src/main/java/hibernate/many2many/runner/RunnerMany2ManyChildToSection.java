package hibernate.many2many.runner;

import hibernate.many2many.entity.Child;
import hibernate.many2many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class RunnerMany2ManyChildToSection {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

            Section section = new Section("Kharate");

            Child childA = new Child("Andrew", 12);
            Child childB = new Child("Tom", 11);
            Child childC= new Child("John", 12);

            section.addChild(childA);
            section.addChild(childB);
            section.addChild(childC);

            session.beginTransaction();

            session.save(section);

            session.getTransaction().commit();
        }finally {
            assert session != null;
            session.close();
            sessionFactory.close();
        }
    }
}
