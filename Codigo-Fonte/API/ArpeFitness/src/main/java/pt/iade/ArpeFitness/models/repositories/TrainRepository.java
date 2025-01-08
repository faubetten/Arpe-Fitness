package pt.iade.ArpeFitness.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iade.ArpeFitness.models.tables.Train;

public interface TrainRepository extends JpaRepository<Train, Integer> {
}
