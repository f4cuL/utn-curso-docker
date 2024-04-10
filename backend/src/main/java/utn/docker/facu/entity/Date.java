package utn.docker.facu.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FECHA")
public class Date {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime fecha;

    public Date() {
    }

    public LocalDateTime getFecha() {
        return fecha;
    }


    public void setFecha(LocalDateTime date) {
        this.fecha = date;
    }

    public Date(LocalDateTime date) {
        this.fecha = date;
    }

    public Date(int id, String name, LocalDateTime date) {
        this.id = id;
        this.fecha = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", fecha='" + getFecha() + "'" +
            "}";
    }
    
}
