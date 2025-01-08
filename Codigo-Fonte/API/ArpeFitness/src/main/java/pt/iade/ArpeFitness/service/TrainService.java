package pt.iade.ArpeFitness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.iade.ArpeFitness.models.tables.ExerSerie;
import pt.iade.ArpeFitness.dto.CreateTrainRequestDTO;
import pt.iade.ArpeFitness.models.ids.ExerSerieId;
import pt.iade.ArpeFitness.models.repositories.*;
import pt.iade.ArpeFitness.models.tables.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private ExerSerieRepository exerSerieRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private SerieTrainRepository serieTrainRepository;

    @Autowired
    private UserTrainRepository userTrainRepository;


    public Train createTrain(CreateTrainRequestDTO request) {
        // Criar o treino
        Train train = new Train();
        train.setTrainName(request.getTrainName());
        trainRepository.save(train);

        // Iterar sobre a lista de exercícios para criar séries e associações
        for (CreateTrainRequestDTO.ExerciseData exercise : request.getExercises()) {
            // Criar a série para o exercício
            Serie serie = new Serie();
            serie.setSerieOrder(exercise.getOrder());
            serie.setSerieRep(exercise.getReps());
            serieRepository.save(serie);

            // Criar o ID composto para ExerSerie
            ExerSerieId exerSerieId = new ExerSerieId();
            exerSerieId.setExerId(exercise.getExerciseId());
            exerSerieId.setSerieId(serie.getSerieId());

            // Associar a série ao exercício
            ExerSerie exerSerie = new ExerSerie();
            exerSerie.setId(exerSerieId); // Configurar o ID composto
            exerSerie.setNumSeries(exercise.getNumSeries());
            exerSerie.setWeightKg(exercise.getWeight());
            exerSerie.setNumReps(exercise.getReps());
            exerSerieRepository.save(exerSerie);
        }


        return train;
    }



    public List<Exercise> getExercisesByTrainId(Integer trainId) {
        // Buscar todas as séries associadas ao treino
        List<SerieTrain> serieTrains = serieTrainRepository.findAllByTrainId(trainId);
        List<Exercise> exercises = new ArrayList<>();

        // Iterar sobre as séries para buscar os exercícios
        for (SerieTrain serieTrain : serieTrains) {
            Integer serieId = serieTrain.getId().getSerieId(); // Obter o ID da série

            // Buscar todas as associações de exercícios com a série
            List<ExerSerie> exerSeries = exerSerieRepository.findAllById_SerieId(serieId);

            // Para cada associação, obter o objeto Exercise e adicioná-lo à lista
            for (ExerSerie exerSerie : exerSeries) {
                Exercise exercise = exerSerie.getExercise();
                exercises.add(exercise); // Adicionar o exercício à lista
            }
        }

        return exercises; // Retornar todos os exercícios encontrados
    }




    public void associateUserToTrain(Integer userId, Integer trainId) {
        UserTrain userTrain = new UserTrain();
        userTrain.setUserId(userId);
        userTrain.setTrainId(trainId);
        userTrainRepository.save(userTrain);
    }


}
