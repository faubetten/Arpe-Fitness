package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.*;
import pt.iade.ArpeFitness.models.ids.SerieTrainId;

@Entity
@IdClass(SerieTrainId.class) // Usando a classe de chave composta
@Table(name = "serie_train")
public class SerieTrain {

    @Id  // Define que este campo faz parte da chave composta
    @ManyToOne
    @JoinColumn(name = "serie_id", nullable = false)
    private Serie serie;

    @Id  // Define que este campo também faz parte da chave composta
    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false)
    private Train train;

    @Column(name = "train_rest_between_exercises", nullable = false)
    private int trainRestBetweenExercises;

    public SerieTrain() {}

    // Getters e Setters
    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public int getTrainRestBetweenExercises() {
        return trainRestBetweenExercises;
    }

    public void setTrainRestBetweenExercises(int trainRestBetweenExercises) {
        this.trainRestBetweenExercises = trainRestBetweenExercises;
    }
}
