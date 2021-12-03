package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String numeroPersona;
    private String nombres;
    private String apellidos;

    @ManyToMany
    private Set<Reunion> reuniones;

    public Set<Reunion> getReuniones(){
        return  reuniones;
    }

    public Persona() {
        reuniones = new HashSet();
    }

    public Persona(String numeroPersona, String nombres, String apellidos) {
        this();
        this.numeroPersona = numeroPersona;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public void addReunion(Reunion reunion){
        reuniones.add(reunion);
        if (!reunion.getParticipantes().contains(this)){
            reunion.addParticipante(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroPersona() {
        return numeroPersona;
    }

    public void setNumeroPersona(String numeroPersona) {
        this.numeroPersona = numeroPersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", numeroPersona='" + numeroPersona + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}
