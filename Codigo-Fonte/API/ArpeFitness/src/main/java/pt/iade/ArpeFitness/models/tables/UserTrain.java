package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.*;
import pt.iade.ArpeFitness.models.ids.UserTrainId;

@Entity
@IdClass(UserTrainId.class) // Usando a classe de chave composta
@Table(name = "user_train")
public class UserTrain {

    @Id // Define que este campo faz parte da chave composta
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Id // Define que este campo também faz parte da chave composta
    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false)
    private Train train;

    public UserTrain() {}

    // Getters e Setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
