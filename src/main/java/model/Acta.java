package model;

import javax.persistence.*;

@Entity
public class Acta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String contenido;

    @OneToOne()
    @JoinColumn
    private Reunion reunion;

    public Acta(){}

    public Acta(String contenido, Reunion reunion) {
        this.contenido = contenido;
        this.reunion = reunion;
        reunion.setActa(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Reunion getReunion() {
        return reunion;
    }

    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
    }


    @Override
    public String toString() {
        return "Acta{" +
                "id=" + id +
                ", contenido='" + contenido + '\'' +
                ", reunion=" + reunion +
                '}';
    }
}
