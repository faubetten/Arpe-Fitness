package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exer_id")
    private Long exer_id;

    @Column(name = "exer_name", nullable = false)
    private String exer_name;

    @Column(name = "exer_description", nullable = false)
    private String exer_description;

    @ManyToOne
    @JoinColumn(name = "exer_cat_id", nullable = false)
    @JsonIgnore // Ignora a serialização da categoria para evitar loops
    private ExerciseCategory exerciseCategory;

    @Column(name = "exer_photo_path")
    private String exer_photo_path;

    public Exercise() {}

    public Long getExer_id() {
        return exer_id;
    }

    public void setExer_id(Long exer_id) {
        this.exer_id = exer_id;
    }

    public String getExer_name() {
        return exer_name;
    }

    public void setExer_name(String exer_name) {
        this.exer_name = exer_name;
    }

    public String getExer_description() {
        return exer_description;
    }

    public void setExer_description(String exer_description) {
        this.exer_description = exer_description;
    }

    public ExerciseCategory getExerciseCategoryd() {
        return exerciseCategory;
    }

    public void setExerciseCategory(ExerciseCategory exerciseCategory) {
        this.exerciseCategory = exerciseCategory;
    }

    public String getExer_photo_path() {
        return exer_photo_path;
    }

    public void setExer_photo_path(String exer_photo_path) {
        this.exer_photo_path = exer_photo_path;
    }
}
