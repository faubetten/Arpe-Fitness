package pt.iade.ArpeFitness.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iade.ArpeFitness.models.tables.UserPlan;

public interface UserPlanRepository  extends JpaRepository<UserPlan, Integer> {
    
}
