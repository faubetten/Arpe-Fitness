package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.*;
import pt.iade.ArpeFitness.models.ids.SerieTrainId;

@Entity
@Table(name = "serie_train")
public class SerieTrain {

    @EmbeddedId
    private SerieTrainId id;

    @ManyToOne
    @MapsId("serieId")
    @JoinColumn(name = "serie_id", insertable = false, updatable = false)
    private Serie serie;

    @ManyToOne
    @MapsId("trainId")
    @JoinColumn(name = "train_id", insertable = false, updatable = false)
    private Train train;

    @Column(name = "train_rest_between_exercises", nullable = false, columnDefinition = "int default 120")
    private int trainRestBetweenExercises;

    public SerieTrain() {}

    public SerieTrainId getId() {
        return id;
    }

    public void setId(SerieTrainId id) {
        this.id = id;
    }

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
