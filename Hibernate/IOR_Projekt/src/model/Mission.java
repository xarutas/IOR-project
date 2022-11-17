package model;

import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="MISSIONS")
public class Mission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MISSION_ID")
    private int id;

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name="MISSIONS_ASTRONAUTS",
            joinColumns=@JoinColumn(name="MISSION_ID"),
            inverseJoinColumns=@JoinColumn(name="ASTRONAUT_ID"),
            foreignKey = @javax.persistence.ForeignKey(name="FK_MISSION_ASTRONAUT"),
            inverseForeignKey = @javax.persistence.ForeignKey(name="FK_ASTRONAUT_MISSION"))
    private Set<Role> role = new HashSet<>(10);

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="TRANSPORT_FLIGHT_ID",foreignKey = @javax.persistence.ForeignKey(name = "FK_TRANSPORTFLIGHT_CARGOS"))
    private Spacecraft spacecraft = new Spacecraft();
    private String destination;
    private String description;
    public Mission(String destination, String description){
        this.destination = destination;
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public String getDestination(){
        return description;
    }

    public Set<Spacecraft> getSpacecraft(){
        return spacecrafts;
    }

    public void setDestination(String destination){
        this.destination = destination;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setSpacecrafts(Set<Spacecraft> spacecrafts) {
        this.spacecrafts = spacecrafts;
    }

}
