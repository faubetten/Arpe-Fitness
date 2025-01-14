package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "exercise_category")
public class ExerciseCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private int catId;

    @Column(name = "cat_name", nullable = false)
    private String catName;

    @OneToMany(mappedBy = "exerciseCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Exercise> exercises;

    public ExerciseCategory() {}

    // Getters e Setters
    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public Set<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Set<Exercise> exercises) {
        this.exercises = exercises;
    }
}