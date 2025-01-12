package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "serie")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serie_id")
    private int serieId;

    @Column(name = "serie_order", nullable = false)
    private int serieOrder;

    @Column(name = "serie_rep", nullable = false)
    private int serieRep;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ExerSerie> exerSeries; // Mapeia a relação intermediária

    public Serie() {}

    // Getters e Setters
    public int getSerieId() {
        return serieId;
    }

    public void setSerieId(int serieId) {
        this.serieId = serieId;
    }

    public int getSerieOrder() {
        return serieOrder;
    }

    public void setSerieOrder(int serieOrder) {
        this.serieOrder = serieOrder;
    }

    public int getSerieRep() {
        return serieRep;
    }

    public void setSerieRep(int serieRep) {
        this.serieRep = serieRep;
    }

    public Set<ExerSerie> getExerSeries() {
        return exerSeries;
    }

    public void setExerSeries(Set<ExerSerie> exerSeries) {
        this.exerSeries = exerSeries;
    }
}
