package pt.iade.ArpeFitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.iade.ArpeFitness.dto.CreateTrainRequestDTO;
import pt.iade.ArpeFitness.dto.CreateTrainRequestDTO;
import pt.iade.ArpeFitness.models.tables.Exercise;
import pt.iade.ArpeFitness.models.tables.Train;
import pt.iade.ArpeFitness.service.TrainService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/train")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @PostMapping("/create")
    public ResponseEntity<Train> createTrain(@Valid @RequestBody CreateTrainRequestDTO request) {
        Train train = trainService.createTrain(request);
        return ResponseEntity.ok(train);
    }

    @GetMapping("/{trainId}/exercises")
    public List<Exercise> getExercises(@PathVariable Integer trainId) {
        return trainService.getExercisesByTrainId(trainId);
    }

    // Endpoint para associar treino a um usuário
    @PostMapping("/{trainId}/assign/{userId}")
    public ResponseEntity<String> assignTrainToUser(
            @PathVariable Integer trainId,
            @PathVariable Integer userId) {
        trainService.associateUserToTrain(trainId, userId);
        return ResponseEntity.ok("Treino associado ao usuário com sucesso.");
    }
}
