package pt.iade.ArpeFitness.models.tables;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "serie")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serie_id")
    private int serie_id;
    
    @Column(nullable = false, name = "serie_order")
    private int serie_order;
    
    @Column(nullable = false, name = "serie_rep")
    private int serie_rep;
    
    @ManyToOne
    @JoinColumn(name = "serie_exer_id", nullable = false)
    private Exercise serie_exer_id;
    
    @ManyToOne
    @JoinColumn(name = "serie_train_id", nullable = false)
    private Train serie_train_id;
    
    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    private Plan plan_id;

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

    public Exercise getSerie_exer_id() {
        return serie_exer_id;
    }

    public void setSerie_exer_id(Exercise serie_exer_id) {
        this.serie_exer_id = serie_exer_id;
    }

    public Train getSerie_train_id() {
        return serie_train_id;
    }

    public void setSerie_train_id(Train serie_train_id) {
        this.serie_train_id = serie_train_id;
    }

    public Plan getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(Plan plan_id) {
        this.plan_id = plan_id;
    }
    
}
