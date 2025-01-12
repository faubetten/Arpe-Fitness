package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.*;
import pt.iade.ArpeFitness.models.enums.TrainGoal;

import java.util.List;

@Entity
@Table(name = "train")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "train_id")
    private int id; // Altere o nome do atributo para "id"

    @Column(name = "train_name", nullable = false, length = 40)
    private String trainName;

    @Enumerated(EnumType.STRING)
    private TrainGoal trainGoal;


    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrainLevel> trainLevels; // Associação com TrainLevel

    public Train() {}

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public TrainGoal getTrainGoal() {
        return trainGoal;
    }

    public void setTrainGoal(TrainGoal trainGoal) {
        this.trainGoal = trainGoal;
    }

    public List<TrainLevel> getTrainLevels() {
        return trainLevels;
    }

    public void setTrainLevels(List<TrainLevel> trainLevels) {
        this.trainLevels = trainLevels;
    }
}
