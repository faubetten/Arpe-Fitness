package pt.iade.ArpeFitness.models.ids;

import java.io.Serializable;
import java.util.Objects;

public class SerieTrainId implements Serializable {

    private Long serie;
    private Long train;

    public SerieTrainId() {}

    // Getters e Setters
    public Long getSerie() {
        return serie;
    }

    public void setSerie(Long serie) {
        this.serie = serie;
    }

    public Long getTrain() {
        return train;
    }

    public void setTrain(Long train) {
        this.train = train;
    }

    // Métodos equals() e hashCode() para garantir comparação correta da chave composta
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SerieTrainId that = (SerieTrainId) o;
        return Objects.equals(serie, that.serie) &&
                Objects.equals(train, that.train);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serie, train);
    }
}
