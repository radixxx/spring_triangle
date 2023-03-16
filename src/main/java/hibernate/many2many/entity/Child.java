package hibernate.many2many.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "children")
public class Child {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    //We describe how current table would be linked with 'Join' table

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "child_section",
    joinColumns = @JoinColumn(name = "child_id"),
    inverseJoinColumns = @JoinColumn(name = "section_id"))
    List<Section> sectionList;

    public void addSection(Section section){
        if(sectionList == null){
            sectionList = new ArrayList<>();
        }
        sectionList.add(section);
    }

    public Child(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
