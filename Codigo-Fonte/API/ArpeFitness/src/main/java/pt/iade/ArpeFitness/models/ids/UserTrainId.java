package pt.iade.ArpeFitness.models.ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserTrainId implements Serializable {

    @Column(name = "user_id")
    private int userId;

    @Column(name = "train_id")
    private int trainId;

    public UserTrainId() {}

    public UserTrainId(int userId, int trainId) {
        this.userId = userId;
        this.trainId = trainId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTrainId that = (UserTrainId) o;
        return userId == that.userId && trainId == that.trainId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, trainId);
    }
}
