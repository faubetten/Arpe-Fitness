package pt.iade.ArpeFitness.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pt.iade.ArpeFitness.dto.ExerciseCategoryDTO;
import pt.iade.ArpeFitness.dto.ExerciseDTO; // Certifique-se de que ExerciseDTO foi criado
import pt.iade.ArpeFitness.models.repositories.ExerciseCategoryRepository;
import pt.iade.ArpeFitness.models.repositories.ExerciseRepository;
import pt.iade.ArpeFitness.models.tables.ExerciseCategory;
import pt.iade.ArpeFitness.models.tables.Exercise;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class ExerciseCategoryController {

    private final ExerciseCategoryRepository exerciseCategoryRepository;
    private final ExerciseRepository exerciseRepository;

    // Endpoint para listar todas as categorias e os seus exercícios
    @GetMapping("/categories")
    public List<ExerciseCategoryDTO> getAllExerciseCategory() {
        List<ExerciseCategory> categories = exerciseCategoryRepository.findAll();
        return categories.stream().map(category ->
                new ExerciseCategoryDTO(
                        (long) category.getCat_id(),
                        category.getCat_name(),
                        // Convertendo exercícios para ExerciseDTO
                        category.getExercises().stream()
                                .map(exercise -> new ExerciseDTO(
                                        exercise.getExer_id(),
                                        exercise.getExer_name(),
                                        exercise.getExer_description(),
                                        exercise.getExer_photo_path()
                                ))
                                .collect(Collectors.toList())
                )
        ).collect(Collectors.toList());
    }

    // Endpoint para listar uma categoria por vez e os seus exercícios
    @GetMapping("/categories/{cat_id}")
    public ExerciseCategoryDTO getExerciseCategoryById(@PathVariable Long cat_id) {
        ExerciseCategory category = exerciseCategoryRepository.findById(cat_id).orElse(null);
        if (category != null) {
            // Convertendo a categoria para DTO e os exercícios também
            return new ExerciseCategoryDTO(
                    (long) category.getCat_id(),
                    category.getCat_name(),
                    category.getExercises().stream()
                            .map(exercise -> new ExerciseDTO(
                                    exercise.getExer_id(),
                                    exercise.getExer_name(),
                                    exercise.getExer_description(),
                                    exercise.getExer_photo_path()
                            ))
                            .collect(Collectors.toList())
            );
        }
        return null; // Ou lance uma exceção personalizada caso não encontre a categoria
    }
}
