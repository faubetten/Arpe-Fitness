package pt.iade.ArpeFitness.dto;

public class ExerciseDTO {
    private int id;
    private String name;
    private String description;
    private String photoPath;
    public ExerciseDTO(int id, String name, String description, String photoPath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photoPath = photoPath; // Inicializando o novo campo

    }

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

}
