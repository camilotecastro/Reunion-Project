package model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reunion")
public class Reunion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime fecha;

    private String asunto;

    @ManyToOne(fetch = FetchType.LAZY)
    private Sala sala;

    @OneToOne(mappedBy = "reunion")
    private Acta acta;

    @ManyToMany(mappedBy = "reuniones", cascade = CascadeType.ALL)
    private Set<Persona> participantes;

    public Reunion(){
        participantes = new HashSet();
    }

    public Reunion(LocalDateTime fecha, String asunto) {
        this();
        this.fecha = fecha;
        this.asunto = asunto;
    }

    public void addParticipante(Persona participante){
        participantes.add(participante);
        if (!participante.getReuniones().contains(this)){
            participante.addReunion(this);
        }
    }

    public Set<Persona> getParticipantes() {
        return participantes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Acta getActa() {
        return acta;
    }

    public void setActa(Acta acta) {
        this.acta = acta;
    }


    @Override
    public String toString() {
        return "Reunion{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", asunto='" + asunto + '\'' +
                '}';
    }
}
