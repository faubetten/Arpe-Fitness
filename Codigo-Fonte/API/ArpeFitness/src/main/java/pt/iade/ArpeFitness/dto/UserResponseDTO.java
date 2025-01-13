package pt.iade.ArpeFitness.dto;

import pt.iade.ArpeFitness.models.enums.UserExperience;
import pt.iade.ArpeFitness.models.enums.UserGoal;

import java.time.LocalDate;

public class UserResponseDTO {

    private Integer userId;
    private String userName;
    private String userEmail;
    private LocalDate userBirthDate;
    private Character userGender;
    private Double userHeight;
    private Double userWeight;
    private UserGoal userGoal;
    private UserExperience userExperience;


    public UserResponseDTO() {
    }

    // Construtor com os campos principais
    public UserResponseDTO(Integer userId, String userName, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    // Construtor completo
    public UserResponseDTO(Integer userId, String userName, String userEmail, LocalDate userBirthDate,
                           Character userGender, Double userHeight, Double userWeight,
                           UserGoal userGoal, UserExperience userExperience) {
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

    // Getters e Setters
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

    public Character getUserGender() {
        return userGender;
    }

    public void setUserGender(Character userGender) {
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

    public UserGoal getUserGoal() {
        return userGoal;
    }

    public void setUserGoal(UserGoal userGoal) {
        this.userGoal = userGoal;
    }

    public UserExperience getUserExperience() {
        return userExperience;
    }

    public void setUserExperience(UserExperience userExperience) {
        this.userExperience = userExperience;
    }
}
