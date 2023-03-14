package hibernate.relations1tomanybi.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "departments")
public class Department {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "max_salary")
    private String maxSalary;

    @Column(name = "min_salary")
    private String minSalary;

    //"mappedBy" - show us where is descriptions of relations between tables
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "department")
    private List<Employee> emps;

    public void addEmployeeToDepartment(Employee employee){
        if(emps == null){
            emps = new ArrayList<>();
        }

        emps.add(employee);
        employee.setDepartment(this);
    }

    public Department(String name, String maxSalary, String minSalary) {
        this.name = name;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }
}
