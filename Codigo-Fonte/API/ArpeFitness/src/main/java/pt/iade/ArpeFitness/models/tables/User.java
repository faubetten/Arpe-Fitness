package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.*;
import java.time.LocalDate;  // Usando LocalDate em vez de java.sql.Date

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;  // Remover o prefixo 'user_' para maior clareza

    @Column(name = "user_name", nullable = false)
    private String userName;  // Renomeado para 'name'

    @Column(name = "user_password")
    private String userPassword;  // Renomeado para 'password'

    @Column(name = "user_bdate", nullable = true)
    private LocalDate userBirthDate;  // Usando LocalDate para datas

    @Column(name = "user_gender", nullable = true)
    private String userGender;  // Renomeado para 'gender'

    @Column(name = "user_email")
    private String userEmail;  // Renomeado para 'email'

    @Column(name = "user_height")
    private double userHeight;  // Renomeado para 'height'

    @Column(name = "user_weight")
    private double userWeight;  // Renomeado para 'weight'

    public User() {}

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

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public double getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(double userHeight) {
        this.userHeight = userHeight;
    }

    public double getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(double userWeight) {
        this.userWeight = userWeight;
    }
}
