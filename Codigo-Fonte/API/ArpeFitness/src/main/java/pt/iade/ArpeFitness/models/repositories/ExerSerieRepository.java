package pt.iade.ArpeFitness.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iade.ArpeFitness.models.ids.ExerSerieId;
import pt.iade.ArpeFitness.models.tables.ExerSerie;

import java.util.List;
import java.util.Optional;

public interface ExerSerieRepository extends JpaRepository<ExerSerie, ExerSerieId> {

    List<ExerSerie> findAllById_SerieId(Integer serieId);

    Optional<ExerSerie> findById_ExerIdAndId_SerieId(Integer exerId, Integer serieId);
}
