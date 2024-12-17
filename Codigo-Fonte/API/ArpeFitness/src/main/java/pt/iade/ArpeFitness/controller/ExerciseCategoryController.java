package pt.iade.ArpeFitness.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pt.iade.ArpeFitness.models.repositories.ExerciseCategoryRepository;
import pt.iade.ArpeFitness.models.tables.ExerciseCategory;

import java.util.List;

@RestController
@AllArgsConstructor
public class ExerciseCategoryController {

    private final ExerciseCategoryRepository repository;

    @GetMapping("/categories")
    public List<ExerciseCategory> getAllExerciseCategory() {
        return repository.findAll();
    }

    @GetMapping("/categories/{cat_id}")
    public ExerciseCategory getExerciseCategoryById(@PathVariable Long cat_id) {
        return repository.findById(cat_id).orElse(null);
    }

    //@PostMapping("/category")
    // Esse método pode ser implementado para adicionar categorias (caso seja necessário)
}

