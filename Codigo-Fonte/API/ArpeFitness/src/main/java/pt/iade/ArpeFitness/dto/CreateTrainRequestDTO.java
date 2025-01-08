package pt.iade.ArpeFitness.dto;

import java.math.BigDecimal;
import java.util.List;

public class CreateTrainRequestDTO {
    private String trainName;
    private List<ExerciseData> exercises;

    public static class ExerciseData {
        private int exerciseId;
        private int order;
        private int reps;
        private int numSeries;
        private BigDecimal weight;

        // Getters e Setters
        public int getExerciseId() {
            return exerciseId;
        }

        public void setExerciseId(int exerciseId) {
            this.exerciseId = exerciseId;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getReps() {
            return reps;
        }

        public void setReps(int reps) {
            this.reps = reps;
        }

        public int getNumSeries() {
            return numSeries;
        }

        public void setNumSeries(int numSeries) {
            this.numSeries = numSeries;
        }

        public BigDecimal getWeight() {
            return weight;
        }

        public void setWeight(BigDecimal weight) {
            this.weight = weight;
        }
    }

    // Getters e Setters para TrainName e Exercises
    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public List<ExerciseData> getExercises() {
        return exercises;
    }

    public void setExercises(List<ExerciseData> exercises) {
        this.exercises = exercises;
    }
}
