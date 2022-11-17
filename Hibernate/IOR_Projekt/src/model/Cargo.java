package model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@PrimaryKeyJoinColumn(name="CARGO_ID", foreignKey = @javax.persistence.ForeignKey(name = "FK_CARGO_TRANSPORTFLIGHT"))
@Table(name="CARGOS")
public class Cargo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CARGO_ID")
    private int id;
    private String type;
    private String description;

    public Cargo(String type, String description){
        this.type = type;
        this.description = description;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getType(){
        return type;
    }

    public String getDescription(){
        return description;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
