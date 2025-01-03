package pt.iade.ArpeFitness.models.ids;

import java.io.Serializable;
import java.util.Objects;

public class UserTrainId implements Serializable {

    private Long user;
    private Long train;

    public UserTrainId() {}

    // Getters e Setters
    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Long getTrain() {
        return train;
    }

    public void setTrain(Long train) {
        this.train = train;
    }

    // Métodos equals() e hashCode() para garantir comparação correta da chave composta
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTrainId that = (UserTrainId) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(train, that.train);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, train);
    }
}
