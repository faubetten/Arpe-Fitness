package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "exercise_category")
public class ExerciseCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private Integer catId; // Alterado de int para Integer

    @Column(name = "cat_name", nullable = false, length = 40)
    private String catName;

    @OneToMany(mappedBy = "exerciseCategory", cascade = CascadeType.ALL)
    private List<Exercise> exercises;

    public ExerciseCategory() {}

    public Integer getCatId() { // Alterado para Integer
        return catId;
    }

    public void setCatId(Integer catId) { // Alterado para Integer
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
