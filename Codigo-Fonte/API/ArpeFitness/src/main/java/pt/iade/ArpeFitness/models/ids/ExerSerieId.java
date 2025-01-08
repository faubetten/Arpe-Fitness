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

    // Getters, Setters, equals e hashCode
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
