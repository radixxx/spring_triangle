package hibernate.hibarnate_relation_one2many_uni.entitiesOne2Many.runner;


import hibernate.hibarnate_relation_one2many_uni.entitiesOne2Many.entity.Department;
import hibernate.hibarnate_relation_one2many_uni.entitiesOne2Many.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class RunTestHibernateOne2ManyDeleteUni {
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

            Department department = session.get(Department.class, 5);

            session.delete(department);

            session.getTransaction().commit(); //always need to close session !
            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }

    }
}
