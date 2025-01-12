package pt.iade.ArpeFitness.dto;

import java.math.BigDecimal;

public class ExerciseDTO {
    private int id; // ID do exercício
    private String name; // Nome do exercício
    private String description; // Descrição do exercício
    private String photoPath; // Caminho da foto do exercício
    private int series; // Número de séries
    private int repetitions; // Número de repetições
    private BigDecimal weight; // Peso associado ao exercício
    private int restTime; // Tempo de descanso em segundos

    // Construtor atualizado
    public ExerciseDTO(int id, String name, String description, String photoPath, int series, int repetitions, BigDecimal weight, int restTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photoPath = photoPath; // Inicializando o novo campo
        this.series = series;
        this.repetitions = repetitions;
        this.weight = weight;
        this.restTime = restTime;
    }

    // Getters e Setters para todos os campos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public int getRestTime() {
        return restTime;
    }

    public void setRestTime(int restTime) {
        this.restTime = restTime;
    }
}
