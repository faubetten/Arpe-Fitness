package pt.iade.ArpeFitness.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class LoginRequestDTO {

    @NotNull(message = "O email é obrigatório.")
    @Email(message = "Formato de email inválido.")
    private String email;

    @NotNull(message = "A senha é obrigatória.")
    private String password;

    // Getters e Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
