package pt.iade.ArpeFitness.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iade.ArpeFitness.models.tables.ExerciseCategory;

public interface ExerciseCategoryRepository extends JpaRepository<ExerciseCategory, Integer> { // Alterado para Integer
}
