package pt.iade.ArpeFitness.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class UserResponseDTO {
    private Integer userId;
    private String userName;
    private String userEmail;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate userBirthDate;

    private String userGender;
    private Double userHeight;
    private Double userWeight;
    private String userGoal;
    private String userExperience;

    // Construtor vazio (necessário para serialização)
    public UserResponseDTO() {}

    // Construtor com os campos principais
    public UserResponseDTO(Integer userId, String userName, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    // Construtor completo
    public UserResponseDTO(
            Integer userId,
            String userName,
            String userEmail,
            LocalDate userBirthDate,
            String userGender,
            Double userHeight,
            Double userWeight,
            String userGoal,
            String userExperience
    ) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
        this.userGender = userGender;
        this.userHeight = userHeight;
        this.userWeight = userWeight;
        this.userGoal = userGoal;
        this.userExperience = userExperience;
    }

    // Getters e setters para todos os campos
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public LocalDate getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(LocalDate userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public Double getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(Double userHeight) {
        this.userHeight = userHeight;
    }

    public Double getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(Double userWeight) {
        this.userWeight = userWeight;
    }

    public String getUserGoal() {
        return userGoal;
    }

    public void setUserGoal(String userGoal) {
        this.userGoal = userGoal;
    }

    public String getUserExperience() {
        return userExperience;
    }

    public void setUserExperience(String userExperience) {
        this.userExperience = userExperience;
    }
}
