package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="ASTRONAUTS")
public class Astronaut implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ASTRONAUT_ID")
    private int id;

    @ManyToMany(mappedBy="astronauts")
    private Set<Mission> missions = new HashSet<>(10);
    private String fName;
    private String lName;
    private String rank;
    private int missionCount;
    private int spaceWalksCount;

    public Astronaut(String fName, String lName, String rank){
        this.fName = fName;
        this.lName = lName;
        this.rank = rank;
    }

    public int getID(){return this.id;}
    public String getFName(){
        return this.fName;
    }
    public String getLName(){
        return this.lName;
    }
    public String getRank(){
        return this.rank;
    }
    public int getMissionCount(){
        return this.missionCount;
    }
    public int getSpaceWalksCount(){
        return this.spaceWalksCount;
    }

    public void setFName(String fName){
         this.fName=fName;
    }
    public void setLName(String lName){
        this.lName=lName;
    }
    public void setRank(String rank){
        this.rank=rank;
    }
    public void setMissionCount(int missionCount){
        this.missionCount=missionCount;
    }
    public void setSpaceWalksCount(int spaceWalksCount){
        this.spaceWalksCount=spaceWalksCount;
    }

}
