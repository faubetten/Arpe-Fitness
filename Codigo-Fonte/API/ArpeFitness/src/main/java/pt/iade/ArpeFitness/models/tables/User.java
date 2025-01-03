package pt.iade.ArpeFitness.models.tables;

import jakarta.persistence.*;
import java.time.LocalDate;  // Usando LocalDate em vez de java.sql.Date

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;  // Remover o prefixo 'user_' para maior clareza

    @Column(name = "user_name", nullable = false)
    private String name;  // Renomeado para 'name'

    @Column(name = "user_password")
    private String password;  // Renomeado para 'password'

    @Column(name = "user_bdate", nullable = true)
    private LocalDate birthDate;  // Usando LocalDate para datas

    @Column(name = "user_gender", nullable = true)
    private String gender;  // Renomeado para 'gender'

    @Column(name = "user_email")
    private String email;  // Renomeado para 'email'

    @Column(name = "user_height")
    private double height;  // Renomeado para 'height'

    @Column(name = "user_weight")
    private double weight;  // Renomeado para 'weight'

    public User() {}

    // Getters e Setters
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
