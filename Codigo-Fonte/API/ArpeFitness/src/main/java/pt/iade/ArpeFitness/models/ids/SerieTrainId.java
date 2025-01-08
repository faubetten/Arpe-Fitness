package pt.iade.ArpeFitness.models.ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SerieTrainId implements Serializable {

    @Column(name = "serie_id")
    private int serieId;

    @Column(name = "train_id")
    private int trainId;

    public SerieTrainId() {}

    public SerieTrainId(int serieId, int trainId) {
        this.serieId = serieId;
        this.trainId = trainId;
    }

    public Integer getSerieId() {
        return serieId;
    }

    public void setSerieId(int serieId) {
        this.serieId = serieId;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SerieTrainId that = (SerieTrainId) o;
        return serieId == that.serieId && trainId == that.trainId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(serieId, trainId);
    }
}
