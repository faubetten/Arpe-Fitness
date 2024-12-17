package pt.iade.ArpeFitness.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pt.iade.ArpeFitness.models.repositories.ExerciseRepository;
import pt.iade.ArpeFitness.models.tables.Exercise;
import pt.iade.ArpeFitness.models.tables.ExerciseCategory;

import java.util.List;

@RestController
@AllArgsConstructor
public class ExerciseController {
    private final ExerciseRepository exerciseRepository;

    @GetMapping("/exercises")
    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    @GetMapping("/exercises/{id}")
    public Exercise getExerciseById(@PathVariable Long id) {
        return exerciseRepository.findById(id).orElse(null);
    }
    
}
