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
    @MapsId("exerId")
    @JoinColumn(name = "exer_id", insertable = false, updatable = false)
    private Exercise exercise;

    @ManyToOne
    @MapsId("serieId")
    @JoinColumn(name = "serie_id", insertable = false, updatable = false)
    private Serie serie;

    @Column(name = "num_series", nullable = false)
    private int numSeries;

    @Column(name = "weight_kg", nullable = false, precision = 5, scale = 2)
    private BigDecimal weightKg;

    @Column(name = "num_reps", nullable = false)
    private int numReps;

    @Column(name = "rest_time_seconds", nullable = false) // Adicionando o campo restTime
    private int restTime;

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

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
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

    public int getRestTime() {
        return restTime;
    }

    public void setRestTime(int restTime) {
        this.restTime = restTime;
    }
}
