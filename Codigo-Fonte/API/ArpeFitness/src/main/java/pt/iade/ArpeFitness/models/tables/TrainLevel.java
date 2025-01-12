package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.*;

@Entity
@Table(name = "train_level")
public class TrainLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false)
    private Train train;

    @Column(name = "train_level")
    private String trainLevel;

    public TrainLevel() {}

    // Enum para os níveis de treino
    public enum Level {
        BEGINNER,
        INTERMEDIATE,
        ADVANCED
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public String getTrainLevel() {
        return trainLevel;
    }

    public void setTrainLevel(String trainLevel) {
        this.trainLevel = trainLevel;
    }
}
