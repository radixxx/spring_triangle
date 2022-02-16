package hibernate.hibarnate_relation_one2many_bi.entitesOne2Many.runner;


import hibernate.hibarnate_relation_one2many_bi.entitesOne2Many.entities.Department;
import hibernate.hibarnate_relation_one2many_bi.entitesOne2Many.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class RunTestHibernateGetOne2Many {
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
            Department department = session.get(Department.class,1);
            System.out.println("Department: " + department + "\n"
                    + "Department Employees: " + department.getEmployeeList());

            Employee employee = session.get(Employee.class, 1);
            System.out.println("Employee: " + employee.getDepartment());


            session.getTransaction().commit(); //always need to close session !
            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }

    }
}
