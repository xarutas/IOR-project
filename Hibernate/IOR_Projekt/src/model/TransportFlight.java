package model;

import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
@Entity
@PrimaryKeyJoinColumn(name="TRANSPORT_FLIGHT_ID", foreignKey = @javax.persistence.ForeignKey(name = "FK_TRANSPORTFLIGHT_MISSION"))
@Table(name="TRANSPORT_FLIGHTS")
public class TransportFlight extends Mission implements Serializable {

    public TransportFlight(String destination, String description) {
        super(destination, description);
    }

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="TRANSPORT_FLIGHT_ID",foreignKey = @javax.persistence.ForeignKey(name = "FK_TRANSPORTFLIGHT_CARGOS"))
    private Set<Cargo> cargos = new HashSet<>(3);

    public Set<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(Set<Cargo> cargos) {
        this.cargos = cargos;
    }
}
