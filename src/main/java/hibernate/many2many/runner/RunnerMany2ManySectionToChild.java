package hibernate.many2many.runner;

import hibernate.many2many.entity.Child;
import hibernate.many2many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunnerMany2ManySectionToChild {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Section.class)
                .addAnnotatedClass(Child.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

            Child childX = new Child("Tom", 10);

            Section sectionA = new Section("Football");
            Section sectionB = new Section("Swimming");
            Section sectionC = new Section("Basketball");

            childX.addSection(sectionA);
            childX.addSection(sectionB);
            childX.addSection(sectionC);

            session.beginTransaction();

            session.save(childX);

            session.getTransaction().commit();
        }finally {
            assert session != null;
            session.close();
            sessionFactory.close();
        }


    }
}
