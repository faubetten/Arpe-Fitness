package pt.iade.ArpeFitness.models.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserExperience {
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced");

    private final String experience;

    UserExperience(String experience) {
        this.experience = experience;
    }

    @JsonValue
    public String getExperience() {
        return experience;
    }

    @JsonCreator
    public static UserExperience fromValue(String value) {
        for (UserExperience experience : UserExperience.values()) {
            if (experience.experience.equalsIgnoreCase(value)) {
                return experience;
            }
        }
        throw new IllegalArgumentException("Invalid UserExperience value: " + value);
    }
}