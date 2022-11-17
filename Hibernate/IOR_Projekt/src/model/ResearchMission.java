package model;

import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
@Entity
@PrimaryKeyJoinColumn(name="RESEARCH_MISSION_ID", foreignKey = @javax.persistence.ForeignKey(name = "FK_RESEARCHMISSION_MISSION"))
@Table(name="RESEARCH_MISSIONS")
public class ResearchMission extends Mission implements Serializable
{
    public ResearchMission(String destination, String description) {super(destination, description);}

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="RESEARCH_MISSION_ID",foreignKey = @javax.persistence.ForeignKey(name = "FK_RESEARCHMISSION_TASKS"))
    private Set<Task> tasks = new HashSet<>(5);

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
