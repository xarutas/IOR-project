package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ROLES")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private int id;
    public String role;

    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="MISSION_ID",foreignKey = @javax.persistence.ForeignKey(name = "FK_ROLE_MISSION"))
    public Mission mission;

    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="ASTRONAUT_ID",foreignKey = @javax.persistence.ForeignKey(name = "FK_ROLE_ASTRONAUT"))
    public Astronaut astronaut;

    public String getRole(){
        return this.role;
    }

    public void setRole(String role){
        this.role = role;
    }

}
