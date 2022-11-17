package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name="SPACECRAFT_ID", foreignKey = @javax.persistence.ForeignKey(name = "FK_SPACECRAFT_MISSION"))
@Table(name="SPACECRAFTS")
public class Spacecraft implements Serializable {

    public Spacecraft(){

    }
    public Spacecraft(String name, int yearOfProduction, int capacity, int numberOfCrewMembers){
        this.name = name;
        this.yearOfProduction = yearOfProduction;
        this.capacity = capacity;
        this.numberOfCrewMembers = numberOfCrewMembers;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SPACECRAFT_ID")
    private int id;
    private String name;

    private int yearOfProduction;
    private int capacity;
    private int numberOfCrewMembers;

    public int getID(){return this.id;}

    public String getName(){
        return this.name;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public int getProductionYear(){
        return this.yearOfProduction;
    }

    public int getNumberOfCrewMembers(){
        return this.numberOfCrewMembers;
    }

    public void setID(int ID){this.id = ID;}

    public void setName(String name){
        this.name = name;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public void setProductionYear(int yearOfProduction){
        this.yearOfProduction = yearOfProduction;
    }

    public void setNumberOfCrewMembers(int numberOfCrewMembers){
        this.numberOfCrewMembers = numberOfCrewMembers;
    }


}
