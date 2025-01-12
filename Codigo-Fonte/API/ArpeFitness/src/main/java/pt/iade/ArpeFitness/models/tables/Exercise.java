package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exer_id")
    private int exerId;

    @Column(name = "exer_name", nullable = false)
    private String exerName;

    @Column(name = "exer_description", nullable = false)
    private String exerDescription;

    @Column(name = "exer_photo_path")
    private String exerPhotoPath;

    @ManyToOne
    @JoinColumn(name = "exer_cat_id", nullable = false) // Relacionamento com a tabela exercise_category
    private ExerciseCategory exerciseCategory;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ExerSerie> exerSeries; // Relacionamento com exer_serie

    public Exercise() {}

    // Getters e Setters
    public int getExerId() {
        return exerId;
    }

    public void setExerId(int exerId) {
        this.exerId = exerId;
    }

    public String getExerName() {
        return exerName;
    }

    public void setExerName(String exerName) {
        this.exerName = exerName;
    }

    public String getExerDescription() {
        return exerDescription;
    }

    public void setExerDescription(String exerDescription) {
        this.exerDescription = exerDescription;
    }

    public String getExerPhotoPath() {
        return exerPhotoPath;
    }

    public void setExerPhotoPath(String exerPhotoPath) {
        this.exerPhotoPath = exerPhotoPath;
    }

    public ExerciseCategory getExerciseCategory() {
        return exerciseCategory;
    }

    public void setExerciseCategory(ExerciseCategory exerciseCategory) {
        this.exerciseCategory = exerciseCategory;
    }

    public Set<ExerSerie> getExerSeries() {
        return exerSeries;
    }

    public void setExerSeries(Set<ExerSerie> exerSeries) {
        this.exerSeries = exerSeries;
    }
}
