package pt.iade.ArpeFitness.models.ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ExerSerieId implements Serializable {

    @Column(name = "exer_id") // Nome físico correto
    private Integer exerId;

    @Column(name = "serie_id") // Nome físico correto
    private Integer serieId;

    // Construtor sem argumentos (necessário para JPA)
    public ExerSerieId() {}

    // Construtor com argumentos
    public ExerSerieId(Integer exerId, Integer serieId) {
        this.exerId = exerId;
        this.serieId = serieId;
    }

    // Getters e Setters
    public Integer getExerId() {
        return exerId;
    }

    public void setExerId(Integer exerId) {
        this.exerId = exerId;
    }

    public Integer getSerieId() {
        return serieId;
    }

    public void setSerieId(Integer serieId) {
        this.serieId = serieId;
    }

    // equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExerSerieId that = (ExerSerieId) o;
        return Objects.equals(exerId, that.exerId) &&
                Objects.equals(serieId, that.serieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exerId, serieId);
    }
}
