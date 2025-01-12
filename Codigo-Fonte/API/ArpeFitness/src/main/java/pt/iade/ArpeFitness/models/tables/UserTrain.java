package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.*;
import pt.iade.ArpeFitness.models.ids.UserTrainId;

@Entity
@Table(name = "user_train")
public class UserTrain {

    @EmbeddedId
    private UserTrainId id;

    @Column(name = "is_custom", nullable = false)
    private boolean isCustom;

    public UserTrain() {}

    public UserTrain(UserTrainId id, boolean isCustom) {
        this.id = id;
        this.isCustom = isCustom;
    }

    public UserTrainId getId() {
        return id;
    }

    public void setId(UserTrainId id) {
        this.id = id;
    }

    public boolean isCustom() {
        return isCustom;
    }

    public void setCustom(boolean custom) {
        isCustom = custom;
    }
}
