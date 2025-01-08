package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "series_reps")
public class SeriesReps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rep_id")
    private int repId;

    @ManyToOne
    @JoinColumn(name = "serie_id", nullable = false)
    private Serie serie;

    @Column(name = "rep_order", nullable = false)
    private int repOrder;

    @Column(name = "rep_weight_kg", precision = 5, scale = 2)
    private BigDecimal repWeightKg;

    @Column(name = "rep_num_reps", nullable = false)
    private int repNumReps;

    @Column(name = "rest_time_seconds", nullable = false)
    private int restTimeSeconds;

    public SeriesReps() {}

    public int getRepId() {
        return repId;
    }

    public void setRepId(int repId) {
        this.repId = repId;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public int getRepOrder() {
        return repOrder;
    }

    public void setRepOrder(int repOrder) {
        this.repOrder = repOrder;
    }

    public BigDecimal getRepWeightKg() {
        return repWeightKg;
    }

    public void setRepWeightKg(BigDecimal repWeightKg) {
        this.repWeightKg = repWeightKg;
    }

    public int getRepNumReps() {
        return repNumReps;
    }

    public void setRepNumReps(int repNumReps) {
        this.repNumReps = repNumReps;
    }

    public int getRestTimeSeconds() {
        return restTimeSeconds;
    }

    public void setRestTimeSeconds(int restTimeSeconds) {
        this.restTimeSeconds = restTimeSeconds;
    }
}
