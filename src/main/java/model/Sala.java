package model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sala {
    @Id
    @Column(length = 20)
    private String id;
    private String descripion;
    private int capacidad;

    @OneToMany(mappedBy = "sala")
    private List<Reunion> reuniones;

    public Sala(){}

    public Sala(String id, String descripion, int capacidad) {
        this.id = id;
        this.descripion = descripion;
        this.capacidad = capacidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public List<Reunion> getReuniones() {
        return reuniones;
    }

    public void setReuniones(List<Reunion> reuniones) {
        this.reuniones = reuniones;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", descripion='" + descripion + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }
}
