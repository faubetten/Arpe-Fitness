package pt.iade.ArpeFitness.models.enums;

public enum UserGoal {
    HYPERTROPHY("Hypertrophy"),
    MUSCLE_DEFINITION("Muscle definition"),
    TO_LOSE_WEIGHT("To lose weight");

    private final String dbValue;

    UserGoal(String dbValue) {
        this.dbValue = dbValue;
    }

    public String getDbValue() {
        return dbValue;
    }

    public static UserGoal fromValue(String value) {
        for (UserGoal goal : UserGoal.values()) {
            if (goal.dbValue.equalsIgnoreCase(value.trim())) {
                return goal;
            }
        }
        throw new IllegalArgumentException("Unknown UserGoal value: " + value);
    }
}
