package hibernate.hibarnate_relation_one2many_uni.entitiesOne2Many.runner;


import hibernate.hibarnate_relation_one2many_uni.entitiesOne2Many.entity.Department;
import hibernate.hibarnate_relation_one2many_uni.entitiesOne2Many.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class RunTestHibernateOne2Many {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try{
            session = factory.getCurrentSession();

            Department department = new Department("Testing", 1100, 1900);
            Employee employee4 = new Employee("Jerry", "Roperro", 1890);
            Employee employee5 = new Employee("Antony", "Scot", 1090);


            department.addEmployeeToDepartment(employee4);
            department.addEmployeeToDepartment(employee5);

            session.beginTransaction();
            session.save(department);


            session.getTransaction().commit(); //always need to close session !
            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }

    }
}
