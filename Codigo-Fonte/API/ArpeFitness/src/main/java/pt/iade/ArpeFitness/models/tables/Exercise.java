package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.*;

@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exer_id")
    private int exerId;

    @Column(name = "exer_name", nullable = false, length = 60)
    private String exerName;

    @Column(name = "exer_description", nullable = false, length = 100)
    private String exerDescription;

    @ManyToOne
    @JoinColumn(name = "exer_cat_id", nullable = false)
    private ExerciseCategory exerciseCategory;

    @Column(name = "exer_photo_path", length = 255)
    private String exerPhotoPath;

    public Exercise() {}

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

    public ExerciseCategory getExerciseCategory() {
        return exerciseCategory;
    }

    public void setExerciseCategory(ExerciseCategory exerciseCategory) {
        this.exerciseCategory = exerciseCategory;
    }

    public String getExerPhotoPath() {
        return exerPhotoPath;
    }

    public void setExerPhotoPath(String exerPhotoPath) {
        this.exerPhotoPath = exerPhotoPath;
    }
}
