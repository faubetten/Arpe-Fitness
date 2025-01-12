package pt.iade.ArpeFitness.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pt.iade.ArpeFitness.models.tables.UserTrain;
import pt.iade.ArpeFitness.models.ids.UserTrainId;

public interface UserTrainRepository extends JpaRepository<UserTrain, UserTrainId> {
    boolean existsById_UserId(Integer userId);

    @Query("SELECT COUNT(ut) FROM UserTrain ut WHERE ut.id.userId = :userId")
    long countByUserId(@Param("userId") int userId);
}
