package pt.iade.ArpeFitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.iade.ArpeFitness.dto.ExerciseDTO;
import pt.iade.ArpeFitness.dto.ExerciseCategoryDTO;
import pt.iade.ArpeFitness.models.repositories.ExerciseCategoryRepository;
import pt.iade.ArpeFitness.models.tables.ExerciseCategory;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories") // Adicionado um prefixo para os endpoints
public class ExerciseCategoryController {

    @Autowired
    private ExerciseCategoryRepository exerciseCategoryRepository;

    // Endpoint para listar todas as categorias com os exercícios associados
    @GetMapping
    public List<ExerciseCategoryDTO> getAllCategories() {
        return exerciseCategoryRepository.findAll().stream()
                .map(category -> new ExerciseCategoryDTO(
                        category.getCatId(),
                        category.getCatName(),
                        category.getExercises().stream()
                                .map(exercise -> new ExerciseDTO(
                                        exercise.getExerId(),
                                        exercise.getExerName(),
                                        exercise.getExerDescription(),
                                        exercise.getExerPhotoPath(),
                                        0, // Valor padrão para séries
                                        0, // Valor padrão para repetições
                                        null, // Peso como null por padrão
                                        0 // Tempo de descanso padrão
                                ))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    // Endpoint para buscar uma categoria específica pelo ID
    @GetMapping("/{id}")
    public ExerciseCategoryDTO getCategoryById(@PathVariable Integer id) {
        ExerciseCategory category = exerciseCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return new ExerciseCategoryDTO(
                category.getCatId(),
                category.getCatName(),
                category.getExercises().stream()
                        .map(exercise -> new ExerciseDTO(
                                exercise.getExerId(),
                                exercise.getExerName(),
                                exercise.getExerDescription(),
                                exercise.getExerPhotoPath(),
                                0, // Valor padrão para séries
                                0, // Valor padrão para repetições
                                null, // Peso como null por padrão
                                0 // Tempo de descanso padrão
                        ))
                        .collect(Collectors.toList())
        );
    }
}