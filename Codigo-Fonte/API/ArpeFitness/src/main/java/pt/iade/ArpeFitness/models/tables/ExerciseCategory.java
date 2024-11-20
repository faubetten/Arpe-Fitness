package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exercise_category")

public class ExerciseCategory {
    @Id @GeneratedValue
    @Column(name = "cat_id")
    private int cat_id;

    @Column(name = "cat_name", nullable = false)
    private String cat_name;

    public ExerciseCategory() {
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    
}
