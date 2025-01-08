package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.*;

@Entity
@Table(name = "train")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "train_id")
    private int id; // Altere o nome do atributo para "id"

    @Column(name = "train_name", nullable = false, length = 40)
    private String trainName;

    public Train() {}

    public int getId() {
        return id; // Ajustado para refletir o novo nome
    }

    public void setId(int id) {
        this.id = id; // Ajustado para refletir o novo nome
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }
}
