package pt.iade.ArpeFitness.models.ids;

import java.io.Serializable;

public class UserPlanId implements Serializable {
    private int user;
    private int plan;
    public UserPlanId(int user, int plan) {
        this.user = user;
        this.plan = plan;
    }
    public int getUser() {
        return user;
    }
    public void setUser(int user) {
        this.user = user;
    }
    public int getPlan() {
        return plan;
    }
    public void setPlan(int plan) {
        this.plan = plan;
    }


    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        UserPlanId that = (UserPlanId) obj;
        return user == that.user && plan == that.plan;
    }

    public int hashCode() {
        return 31 * user + plan;
    }

    

    
}
