package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;




@Entity
@Table(name = "exercise")
public class Exercise {
    @Id @GeneratedValue
    @Column(name = "exer_id")
    private int exer_id;

    @Column(name = "exer_name", nullable = false)
    private String exer_name;

    @Column(name = "exer_description", nullable = false)
    private String exer_description;

    @ManyToOne
    @JoinColumn(name = "exer_cat_id")
    private ExerciseCategory exer_cat_id;

    public Exercise() {
    }

    public int getExer_id() {
        return exer_id;
    }

    public void setExer_id(int exer_id) {
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

    public ExerciseCategory getExer_cat_id() {
        return exer_cat_id;
    }

    public void setExer_cat_id(ExerciseCategory exer_cat_id) {
        this.exer_cat_id = exer_cat_id;
    }



}
