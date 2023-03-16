package hibernate.many2many.runner;

import hibernate.many2many.entity.Child;
import hibernate.many2many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunnerGetValues {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Section.class)
                .addAnnotatedClass(Child.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Section section = session.get(Section.class, 1);
            session.beginTransaction().commit();
        }finally {
            assert session != null;
            session.close();
            sessionFactory.close();
        }

    }
}
