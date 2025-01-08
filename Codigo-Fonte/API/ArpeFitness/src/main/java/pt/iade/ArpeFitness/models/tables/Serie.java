package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "serie")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serie_id")
    private int serieId;

    @Column(name = "serie_order", nullable = false)
    private int serieOrder;

    @Column(name = "serie_rep", nullable = false)
    private int serieRep;

    @ManyToMany
    @JoinTable(
            name = "exer_serie",
            joinColumns = @JoinColumn(name = "serie_id"),
            inverseJoinColumns = @JoinColumn(name = "exer_id")
    )
    private Set<Exercise> exercises;

    public Serie() {}

    public int getSerieId() {
        return serieId;
    }

    public void setSerieId(int serieId) {
        this.serieId = serieId;
    }

    public int getSerieOrder() {
        return serieOrder;
    }

    public void setSerieOrder(int serieOrder) {
        this.serieOrder = serieOrder;
    }

    public int getSerieRep() {
        return serieRep;
    }

    public void setSerieRep(int serieRep) {
        this.serieRep = serieRep;
    }

    public Set<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Set<Exercise> exercises) {
        this.exercises = exercises;
    }
}
