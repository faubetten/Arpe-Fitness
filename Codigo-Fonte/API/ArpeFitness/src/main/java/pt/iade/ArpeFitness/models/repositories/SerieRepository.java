package pt.iade.ArpeFitness.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iade.ArpeFitness.models.tables.Serie;

public interface SerieRepository extends JpaRepository<Serie, Integer> {
}
