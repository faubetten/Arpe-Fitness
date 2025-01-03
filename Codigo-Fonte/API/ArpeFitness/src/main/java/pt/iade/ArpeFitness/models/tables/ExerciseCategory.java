package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore; // Importando a anotação

import java.util.List;

@Entity
@Table(name = "exercise_category")
public class ExerciseCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private long cat_id;

    @Column(name = "cat_name", nullable = false)
    private String cat_name;

    @OneToMany(mappedBy = "exerciseCategory")
    private List<Exercise> exercises;

    public ExerciseCategory() {}

    public long getCat_id() {
        return cat_id;
    }

    public void setCat_id(long cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
