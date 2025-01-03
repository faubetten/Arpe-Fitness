package pt.iade.ArpeFitness.models.tables;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "series_reps")

public class SeriesReps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rep_id")
    private int rep_id;

    @ManyToOne
    @JoinColumn(name = "serie_id", nullable = false)
    private Serie serie_id;

    @Column(name = "rep_order", nullable = false)
    private int rep_order;

    @Column(name = "rep_weight_kg")
    private BigDecimal rep_weight_kg;

    @Column(name = "rep_num_reps", nullable = false)
    private int rep_num_reps;

    @Column(name = "rest_time_seconds", nullable = false)
    private int rest_time_seconds;

    public SeriesReps() {
    }

    public int getRep_id() {
        return rep_id;
    }

    public void setRep_id(int rep_id) {
        this.rep_id = rep_id;
    }

    public Serie getSerie_id() {
        return serie_id;
    }

    public void setSerie_id(Serie serie_id) {
        this.serie_id = serie_id;
    }

    public int getRep_order() {
        return rep_order;
    }

    public void setRep_order(int rep_order) {
        this.rep_order = rep_order;
    }

    public BigDecimal getRep_weight_kg() {
        return rep_weight_kg;
    }

    public void setRepWeightKg(BigDecimal repWeightKg) {
        this.rep_weight_kg = rep_weight_kg;
    }

    public int getRep_num_reps() {
        return rep_num_reps;
    }

    public void setRep_num_reps(int rep_num_reps) {
        this.rep_num_reps = rep_num_reps;
    }

    public int getRest_time_seconds() {
        return rest_time_seconds;
    }

    public void setRest_time_seconds(int rest_time_seconds) {
        this.rest_time_seconds = rest_time_seconds;
    }
}
