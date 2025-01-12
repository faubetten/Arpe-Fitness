package pt.iade.ArpeFitness.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pt.iade.ArpeFitness.models.tables.SerieTrain;
import pt.iade.ArpeFitness.models.ids.SerieTrainId;

import java.util.List;
import java.util.Optional;

public interface SerieTrainRepository extends JpaRepository<SerieTrain, SerieTrainId> {

    @Query("SELECT st FROM SerieTrain st WHERE st.id.trainId = :trainId AND st.trainLevel.trainLevel = :levelName")
    List<SerieTrain> findByTrainIdAndLevelName(@Param("trainId") int trainId, @Param("levelName") String levelName);

    List<SerieTrain> findAllById_TrainId(Integer trainId);

}
