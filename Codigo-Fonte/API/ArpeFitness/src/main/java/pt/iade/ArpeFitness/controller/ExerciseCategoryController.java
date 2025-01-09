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

public class ExerciseCategoryController {

    @Autowired
    private ExerciseCategoryRepository exerciseCategoryRepository;

    @GetMapping("/categories")
    public List<ExerciseCategoryDTO> getAllCategories() {
        return exerciseCategoryRepository.findAll().stream()
                .map(category -> new ExerciseCategoryDTO(
                        category.getCatId(), // Mantém int
                        category.getCatName(),
                        category.getExercises().stream()
                                .map(exercise -> new ExerciseDTO(
                                        exercise.getExerId(), // Mantém int
                                        exercise.getExerName(),
                                        exercise.getExerDescription(),
                                        exercise.getExerPhotoPath()
                                ))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("/categories/{id}")
    public ExerciseCategoryDTO getCategoryById(@PathVariable Integer id) { // Alterado para Integer
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
                                exercise.getExerPhotoPath()
                        ))
                        .collect(Collectors.toList())
        );
    }

}
