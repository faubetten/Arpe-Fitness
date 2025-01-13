package pt.iade.ArpeFitness.models.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserGoal {
    HYPERTROPHY("Hypertrophy"),
    MUSCLE_DEFINITION("Muscle Definition"),
    TO_LOSE_WEIGHT("To lose weight");

    private final String value;

    UserGoal(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static UserGoal fromValue(String value) {
        for (UserGoal goal : UserGoal.values()) {
            if (goal.value.equalsIgnoreCase(value)) {
                return goal;
            }
        }
        throw new IllegalArgumentException("Invalid value for UserGoal: " + value);
    }
}