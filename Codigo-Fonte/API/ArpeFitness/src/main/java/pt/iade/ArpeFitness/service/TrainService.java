package pt.iade.ArpeFitness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.iade.ArpeFitness.dto.TrainRequestDTO;
import pt.iade.ArpeFitness.models.enums.TrainGoal;
import pt.iade.ArpeFitness.models.ids.ExerSerieId;
import pt.iade.ArpeFitness.models.ids.UserTrainId;
import pt.iade.ArpeFitness.models.repositories.*;
import pt.iade.ArpeFitness.models.tables.*;

import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private ExerSerieRepository exerSerieRepository;

    @Autowired
    private SerieTrainRepository serieTrainRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTrainRepository userTrainRepository;

    /**
     * Cria um treino baseado no nível e associa exercícios configurados.
     *
     * @param request DTO contendo informações do usuário e configuração do treino.
     * @return O treino criado.
     */
    public Train createTrainWithLevel(TrainRequestDTO request) {
        // Verificar se o usuário existe
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuário com ID " + request.getUserId() + " não encontrado."));

        // Gerar o nome do treino
        long trainCount = userTrainRepository.countByUserId(request.getUserId());
        String trainName = "Treino " + (trainCount + 1);

        // Criar o treino
        Train train = new Train();
        train.setTrainName(trainName);
        train.setTrainGoal(TrainGoal.fromUserGoal(user.getUserGoal())); // Converter UserGoal para TrainGoal
        trainRepository.save(train);

        // Associar o treino ao usuário
        UserTrainId userTrainId = new UserTrainId(request.getUserId(), train.getId());
        UserTrain userTrain = new UserTrain();
        userTrain.setId(userTrainId);
        userTrain.setCustom(true);
        userTrainRepository.save(userTrain);

        // Configurar os exercícios
        configureExercisesForTrain(train, request);

        return train;
    }


    private void configureExercisesForTrain(Train train, TrainRequestDTO request) {
        for (Integer exerciseId : request.getExerciseIds()) {
            // Buscar as configurações para o nível usando o nome
            List<SerieTrain> serieTrains = serieTrainRepository.findByTrainIdAndLevelName(train.getId(), request.getLevel());

            if (serieTrains.isEmpty()) {
                throw new RuntimeException("Nenhuma configuração de série encontrada para o nível " + request.getLevel());
            }

            for (SerieTrain serieTrain : serieTrains) {
                // Criar a série
                Serie serie = new Serie();
                serie.setSerieOrder(serieTrain.getNumSeries());
                serie.setSerieRep(serieTrain.getNumReps());
                serieRepository.save(serie);

                // Associar o exercício à série
                ExerSerie exerSerie = new ExerSerie();
                exerSerie.setId(new ExerSerieId(exerciseId, serie.getSerieId()));
                exerSerie.setNumSeries(serieTrain.getNumSeries());
                exerSerie.setWeightKg(serieTrain.getWeightKg());
                exerSerie.setNumReps(serieTrain.getNumReps());
                exerSerieRepository.save(exerSerie);
            }
        }
    }
}
