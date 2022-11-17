package model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@PrimaryKeyJoinColumn(name="TASK_ID", foreignKey = @javax.persistence.ForeignKey(name = "FK_TASK_RESEARCHMISSION"))
@Table(name="TASKS")
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TASK_ID")
    private int id;
    private String name;
    private String description;

    public Task(String name, String description){
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
