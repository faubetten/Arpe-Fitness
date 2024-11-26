package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "plan")
public class Plan {
    @Id @GeneratedValue
    @Column(name = "plan_id")
    private int plan_id;

    @Column(name = "plan_name", nullable = false)
    private String plan_name;

    @Column(name = "plan_desc")
    private String plan_desc;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user_id;

    public Plan() {
    }

    public int getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(int plan_id) {
        this.plan_id = plan_id;
    }

    public String getPlan_name() {
        return plan_name;
    }

    public void setPlan_name(String plan_name) {
        this.plan_name = plan_name;
    }

    public String getPlan_desc() {
        return plan_desc;
    }

    public void setPlan_description(String plan_desc) {
        this.plan_desc = plan_desc;
    }
    
}
