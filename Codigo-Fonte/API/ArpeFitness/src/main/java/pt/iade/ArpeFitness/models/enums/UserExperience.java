package pt.iade.ArpeFitness.models.enums;

public enum UserExperience {
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced");

    private final String experience;

    UserExperience(String experience) {
        this.experience = experience;
    }

    public String getExperience() {
        return experience;
    }

    public static UserExperience fromValue(String value) {
        for (UserExperience experience : UserExperience.values()) {
            if (experience.getExperience().equalsIgnoreCase(value)) {
                return experience;
            }
        }
        throw new IllegalArgumentException("Unknown value for UserExperience: " + value);
    }

    @Override
    public String toString() {
        return experience;
    }
}
