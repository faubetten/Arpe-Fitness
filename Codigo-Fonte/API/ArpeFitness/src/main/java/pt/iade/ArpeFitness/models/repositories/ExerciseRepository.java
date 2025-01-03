package pt.iade.ArpeFitness.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iade.ArpeFitness.models.tables.Exercise;
import pt.iade.ArpeFitness.models.tables.ExerciseCategory;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findByExerciseCategory(ExerciseCategory exerciseCategory);
}

