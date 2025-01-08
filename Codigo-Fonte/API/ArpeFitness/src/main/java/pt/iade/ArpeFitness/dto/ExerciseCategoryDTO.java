package pt.iade.ArpeFitness.dto;

import java.util.List;

public class ExerciseCategoryDTO {
    private int id;
    private String name;
    private List<ExerciseDTO> exercises;

    public ExerciseCategoryDTO(int id, String name, List<ExerciseDTO> exercises) {
        this.id = id;
        this.name = name;
        this.exercises = exercises;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ExerciseDTO> getExercises() {
        return exercises;
    }

    public void setExercises(List<ExerciseDTO> exercises) {
        this.exercises = exercises;
    }
}
