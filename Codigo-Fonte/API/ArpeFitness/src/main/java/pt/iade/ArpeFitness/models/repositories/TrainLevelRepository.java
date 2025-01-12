package pt.iade.ArpeFitness.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iade.ArpeFitness.models.tables.TrainLevel;

public interface TrainLevelRepository extends JpaRepository<TrainLevel, Integer> {
    // Adicione métodos customizados se necessário
}
