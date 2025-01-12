package pt.iade.ArpeFitness.dto;

import java.math.BigDecimal;
import java.util.List;

public class TrainRequestDTO {

    private int userId; // ID do usuário
    private String trainGoal; // Objetivo do treino
    private String level; // Beginner, Intermediate, Advanced
    private List<ExerciseDTO> exercises; // Lista de exercícios
    private List<Integer> exerciseIds;
    private int levelId;

    // Getters e Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTrainGoal() {
        return trainGoal;
    }

    public void setTrainGoal(String trainGoal) {
        this.trainGoal = trainGoal.toUpperCase(); // Converte para maiúsculas para alinhar com o ENUM
    }

    public String getLevel() {
        return level;
    }


    public void setLevel(String level) {
        this.level = level.toUpperCase(); // Converter para maiúsculas
    }

    public List<Integer> getExerciseIds() {
        return exerciseIds;
    }
    public void setExerciseIds(List<Integer> exerciseIds) {
        this.exerciseIds = exerciseIds;
    }


    public List<ExerciseDTO> getExercises() {
        return exercises;
    }

    public void setExercises(List<ExerciseDTO> exercises) {
        this.exercises = exercises;
    }

    // Classe interna representando cada exercício no treino
    public static class ExerciseDTO {
        private int exerciseId; // ID do exercício
        private int series; // Número de séries
        private int repetitions; // Número de repetições
        private BigDecimal weight; // Peso em kg
        private int restTime;

        // Getters e Setters
        public int getExerciseId() {
            return exerciseId;
        }

        public void setExerciseId(int exerciseId) {
            this.exerciseId = exerciseId;
        }

        public int getSeries() {
            return series;
        }

        public void setSeries(int series) {
            this.series = series;
        }

        public int getRepetitions() {
            return repetitions;
        }

        public void setRepetitions(int repetitions) {
            this.repetitions = repetitions;
        }

        public BigDecimal getWeight() {
            return weight;
        }

        public void setWeight(BigDecimal weight) {
            this.weight = weight;
        }

        public int getRestTime() {
            return restTime;
        }

        public void setRestTime(int restTime) {
            this.restTime = restTime;
        }
    }
}
