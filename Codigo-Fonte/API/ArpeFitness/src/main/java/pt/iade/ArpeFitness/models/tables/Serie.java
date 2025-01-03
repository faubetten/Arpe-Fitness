package pt.iade.ArpeFitness.models.tables;
import jakarta.persistence.*;

@Entity
@Table(name = "serie")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serie_id")
    private int serie_id;

    @Column(name = "serie_order", nullable = false)
    private int serie_order;

    @Column(name = "serie_rep", nullable = false)
    private int serie_rep;

    public Serie() {
    }

    public int getSerie_id() {
        return serie_id;
    }

    public void setSerie_id(int serie_id) {
        this.serie_id = serie_id;
    }

    public int getSerie_order() {
        return serie_order;
    }

    public void setSerie_order(int serie_order) {
        this.serie_order = serie_order;
    }

    public int getSerie_rep() {
        return serie_rep;
    }

    public void setSerie_rep(int serie_rep) {
        this.serie_rep = serie_rep;
    }
}
