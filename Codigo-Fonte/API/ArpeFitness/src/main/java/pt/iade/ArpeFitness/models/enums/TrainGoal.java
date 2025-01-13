package pt.iade.ArpeFitness.models.enums;

public enum TrainGoal {
    HYPERTROPHY("Hypertrophy"),
    MUSCLE_DEFINITION("Muscle Definition"),
    TO_LOSE_WEIGHT("To lose weight");

    private final String dbValue;

    TrainGoal(String dbValue) {
        this.dbValue = dbValue;
    }

    public String getDbValue() {
        return dbValue;
    }

    public static TrainGoal fromDbValue(String dbValue) {
        for (TrainGoal goal : TrainGoal.values()) {
            if (goal.dbValue.equalsIgnoreCase(dbValue)) {
                return goal;
            }
        }
        throw new IllegalArgumentException("Invalid TrainGoal value: " + dbValue);
    }

    // Adicionar o método fromUserGoal
    public static TrainGoal fromUserGoal(UserGoal userGoal) {
        switch (userGoal) {
            case HYPERTROPHY:
                return HYPERTROPHY;
            case MUSCLE_DEFINITION:
                return MUSCLE_DEFINITION;
            case TO_LOSE_WEIGHT:
                return TO_LOSE_WEIGHT;
            default:
                throw new IllegalArgumentException("No corresponding TrainGoal for UserGoal: " + userGoal);
        }
    }
}