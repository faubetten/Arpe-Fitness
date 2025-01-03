package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.*;

@Entity
@Table(name = "train")

public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "train_id")
    private int train_id;

    @Column(name = "train_name", nullable = false)
    private String train_name;

    public Train() {
    }

    public int getTrain_id() {
        return train_id;
    }

    public void setTrain_id(int train_id) {
        this.train_id = train_id;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }
}
