package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.*;
import pt.iade.ArpeFitness.models.ids.ExerSerieId;

import java.math.BigDecimal;

@Entity
@IdClass(ExerSerieId.class)  // Definição da chave composta
@Table(name = "exer_serie")
public class ExerSerie {

    @Id
    @Column(name = "exer_id")
    private int exerId;

    @Id
    @Column(name = "serie_id")
    private int serieId;

    @Column(name = "num_series", nullable = false)
    private int num_series;

    @Column(name = "weight_kg", nullable = false, precision = 10, scale = 2)
    private BigDecimal weight_kg;

    @Column(name = "num_reps", nullable = false)
    private int num_reps;

    @ManyToOne
    @JoinColumn(name = "exer_id", insertable = false, updatable = false)  // Relacionamento com Exercise
    private Exercise exer;

    @ManyToOne
    @JoinColumn(name = "serie_id", insertable = false, updatable = false)  // Relacionamento com Serie
    private Serie serie;

    public ExerSerie() {
    }

    // Getters e setters
    public int getExerId() {
        return exerId;
    }

    public void setExerId(int exerId) {
        this.exerId = exerId;
    }

    public int getSerieId() {
        return serieId;
    }

    public void setSerieId(int serieId) {
        this.serieId = serieId;
    }

    public int getNum_series() {
        return num_series;
    }

    public void setNum_series(int num_series) {
        this.num_series = num_series;
    }

    public BigDecimal getWeightKg() {
        return weight_kg;
    }

    public void setWeightKg(BigDecimal weightKg) {
        this.weight_kg = weightKg;
    }

    public int getNum_reps() {
        return num_reps;
    }

    public void setNum_reps(int num_reps) {
        this.num_reps = num_reps;
    }

    public Exercise getExer() {
        return exer;
    }

    public void setExer(Exercise exer) {
        this.exer = exer;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }
}
