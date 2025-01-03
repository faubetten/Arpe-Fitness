package pt.iade.ArpeFitness.models.ids;

import java.io.Serializable;

public class ExerSerieId implements Serializable {

    private int exerId;   // Renomeado para refletir claramente que é o ID de Exercise
    private int serieId;  // Renomeado para refletir claramente que é o ID de Serie

    public ExerSerieId() {
        // Construtor sem parâmetros é necessário para JPA
    }

    public ExerSerieId(int exerId, int serieId) {
        this.exerId = exerId;
        this.serieId = serieId;
    }

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ExerSerieId that = (ExerSerieId) obj;
        return exerId == that.exerId && serieId == that.serieId;
    }

    @Override
    public int hashCode() {
        return 31 * exerId + serieId;
    }
}
