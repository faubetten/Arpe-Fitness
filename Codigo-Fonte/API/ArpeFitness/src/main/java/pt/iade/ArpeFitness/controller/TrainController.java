package pt.iade.ArpeFitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.iade.ArpeFitness.dto.TrainRequestDTO;
import pt.iade.ArpeFitness.models.enums.TrainGoal;
import pt.iade.ArpeFitness.models.tables.Exercise;
import pt.iade.ArpeFitness.models.tables.Train;
import pt.iade.ArpeFitness.service.TrainService;
import pt.iade.ArpeFitness.dto.TrainRequestDTO;


import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/train")
public class TrainController {

    @Autowired
    private TrainService trainService;

    // Endpoint para criar treino
    @PostMapping("/create")
    public ResponseEntity<?> createTrain(@RequestBody TrainRequestDTO trainRequest) {
        TrainGoal trainGoal = TrainGoal.fromDbValue(trainRequest.getTrainGoal());
        // Lógica para criar o treino
        return ResponseEntity.ok("Treino criado com sucesso!");
    }


    // Endpoint para listar exercícios de um treino específico
    /*@GetMapping("/{trainId}/exercises")
    public ResponseEntity<List<Exercise>> getExercises(@PathVariable Integer trainId) {
        try {
            List<Exercise> exercises = trainService.getExercisesByTrainId(trainId);
            return ResponseEntity.ok(exercises);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Endpoint para associar treino a um usuário
    @PostMapping("/{trainId}/assign/{userId}")
    public ResponseEntity<String> assignTrainToUser(
            @PathVariable Integer trainId,
            @PathVariable Integer userId) {
        try {
            trainService.associateUserToTrain(trainId, userId);
            return ResponseEntity.ok("Treino associado ao usuário com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }*/
}
