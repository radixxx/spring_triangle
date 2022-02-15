package hibernate.hibarnate_relations.runner;


import hibernate.hibarnate_relations.relatedEntities.Detail;
import hibernate.hibarnate_relations.relatedEntities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class  RunTestHibernate {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        try{
            Session session = factory.getCurrentSession();

            Employee employee = new Employee("Ben", "Mann", "Sales", 900);
            Detail detail = new Detail("Moscow", "+38057585", "ben_mann@mail.com");

            employee.setEmpDetail(detail);
            session.beginTransaction(); //save the created obj

            session.save(employee);

            session.getTransaction().commit(); //always need to close session !
            System.out.println("Done");
        } finally {
            factory.close();
        }

    }
}
