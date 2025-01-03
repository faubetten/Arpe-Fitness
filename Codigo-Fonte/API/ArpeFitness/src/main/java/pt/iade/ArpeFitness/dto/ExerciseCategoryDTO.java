package pt.iade.ArpeFitness.dto;

import java.util.List;

public class ExerciseCategoryDTO {
    private Long id;
    private String name;
    private List<ExerciseDTO> exercises;

    // Construtores, getters e setters
    public ExerciseCategoryDTO(Long id, String name, List<ExerciseDTO> exercises) {
        this.id = id;
        this.name = name;
        this.exercises = exercises;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
