package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.*;
import pt.iade.ArpeFitness.models.enums.TrainGoal;
import pt.iade.ArpeFitness.models.enums.UserExperience;
import pt.iade.ArpeFitness.models.enums.UserGoal;

import java.time.LocalDate;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "user_bdate", nullable = true)
    private LocalDate userBirthDate;

    @Column(name = "user_gender", nullable = true)
    private Character userGender;


    @Column(name = "user_email", nullable = true, length = 30)
    private String userEmail;

    @Column(name = "user_height", nullable = true)
    private Double userHeight;

    @Column(name = "user_weight", nullable = true)
    private Double userWeight;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_goal", nullable = true)
    private UserGoal userGoal;

    @Column(name = "user_experience")
    private String userExperienceValue;

    public User() {
    }

    // Getters e Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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
        return UserExperience.fromValue(userExperienceValue);
    }

    public void setUserExperience(UserExperience userExperience) {
        this.userExperienceValue = userExperience.getExperience();
    }
}
