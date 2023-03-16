package hibernate.many2many.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "section")
public class Section {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    //We describe how current table would be linked with 'Join' table

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "child_section",
            joinColumns = @JoinColumn(name = "section_id"),
            inverseJoinColumns = @JoinColumn(name = "child_id"))
    List<Child> childList;

    public void addChild(Child child){
        if(childList == null){
            childList = new ArrayList<>();
        }
        childList.add(child);
    }

    public Section(String name) {
        this.name = name;
    }
}
