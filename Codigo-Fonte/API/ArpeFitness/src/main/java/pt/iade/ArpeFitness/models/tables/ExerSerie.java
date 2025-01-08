package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.*;
import pt.iade.ArpeFitness.models.ids.ExerSerieId;

import java.math.BigDecimal;

@Entity
@Table(name = "exer_serie")
public class ExerSerie {

    @EmbeddedId
    private ExerSerieId id;

    @ManyToOne
    @JoinColumn(name = "exer_id", insertable = false, updatable = false) // Mapeamento correto
    private Exercise exercise;

    @Column(name = "num_series", nullable = false)
    private int numSeries;

    @Column(name = "weight_kg", nullable = false)
    private BigDecimal weightKg;

    @Column(name = "num_reps", nullable = false)
    private int numReps;

    // Getters e Setters
    public ExerSerieId getId() {
        return id;
    }

    public void setId(ExerSerieId id) {
        this.id = id;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public int getNumSeries() {
        return numSeries;
    }

    public void setNumSeries(int numSeries) {
        this.numSeries = numSeries;
    }

    public BigDecimal getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(BigDecimal weightKg) {
        this.weightKg = weightKg;
    }

    public int getNumReps() {
        return numReps;
    }

    public void setNumReps(int numReps) {
        this.numReps = numReps;
    }
}
