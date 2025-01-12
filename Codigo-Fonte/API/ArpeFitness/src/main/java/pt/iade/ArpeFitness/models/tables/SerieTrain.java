package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.*;
import pt.iade.ArpeFitness.models.ids.SerieTrainId;

import java.math.BigDecimal;

@Entity
@Table(name = "serie_train")
public class SerieTrain {

    @EmbeddedId
    private SerieTrainId id;

    @ManyToOne
    @JoinColumn(name = "level_id", referencedColumnName = "level_id", insertable = false, updatable = false)
    private TrainLevel trainLevel;


    @ManyToOne
    @MapsId("trainId")
    @JoinColumn(name = "train_id", referencedColumnName = "train_id", insertable = false, updatable = false)
    private Train train;

    @ManyToOne
    @MapsId("serieId")
    @JoinColumn(name = "serie_id", referencedColumnName = "serie_id", insertable = false, updatable = false)
    private Serie serie;

    @Column(name = "train_rest_between_exercises")
    private int trainRestBetweenExercises;

    @Column(name = "num_series")
    private int numSeries;

    @Column(name = "num_reps")
    private int numReps;

    @Column(name = "weight_kg")
    private BigDecimal weightKg;

    // Getters e Setters
    public SerieTrainId getId() {
        return id;
    }

    public void setId(SerieTrainId id) {
        this.id = id;
    }

    public TrainLevel getTrainLevel() {
        return trainLevel;
    }

    public void setTrainLevel(TrainLevel trainLevel) {
        this.trainLevel = trainLevel;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public int getTrainRestBetweenExercises() {
        return trainRestBetweenExercises;
    }

    public void setTrainRestBetweenExercises(int trainRestBetweenExercises) {
        this.trainRestBetweenExercises = trainRestBetweenExercises;
    }

    public int getNumSeries() {
        return numSeries;
    }

    public void setNumSeries(int numSeries) {
        this.numSeries = numSeries;
    }

    public int getNumReps() {
        return numReps;
    }

    public void setNumReps(int numReps) {
        this.numReps = numReps;
    }

    public BigDecimal getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(BigDecimal weightKg) {
        this.weightKg = weightKg;
    }
}
