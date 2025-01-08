package pt.iade.ArpeFitness.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iade.ArpeFitness.models.tables.SerieTrain;
import pt.iade.ArpeFitness.models.ids.SerieTrainId;

import java.util.List;

public interface SerieTrainRepository extends JpaRepository<SerieTrain, SerieTrainId> {
    List<SerieTrain> findAllByTrainId(Integer trainId);
}
