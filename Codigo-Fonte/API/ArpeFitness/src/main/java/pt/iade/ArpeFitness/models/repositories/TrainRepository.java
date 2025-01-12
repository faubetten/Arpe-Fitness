package pt.iade.ArpeFitness.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pt.iade.ArpeFitness.models.tables.Train;

public interface TrainRepository extends JpaRepository<Train, Integer> {

    @Query("SELECT COUNT(t) FROM Train t JOIN UserTrain ut ON t.id = ut.id.trainId WHERE ut.id.userId = :userId")
    long countByUserId(Integer userId);
}
