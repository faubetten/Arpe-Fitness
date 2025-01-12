package pt.iade.ArpeFitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.iade.ArpeFitness.dto.LoginRequestDTO;
import pt.iade.ArpeFitness.dto.UserResponseDTO;
import pt.iade.ArpeFitness.models.tables.User;
import pt.iade.ArpeFitness.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint para cadastrar a primeira parte do usuário (nome, email, senha)
    @PostMapping("/create")
    public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        String response = userService.createUserInitial(user);
        if (response.equals("Erro: Email já cadastrado.")) {
            return new ResponseEntity<>("O email informado já está em uso. Por favor, tente outro.", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Usuário criado com sucesso!", HttpStatus.CREATED);
    }

    // Endpoint para atualizar as informações do usuário após o cadastro (data de nascimento, gênero, etc)
    @PutMapping("/{userId}/update")
    public ResponseEntity<User> updateUserInfo(@PathVariable Integer userId, @RequestBody User updatedUser) {
        try {
            User updated = userService.updateUserInfo(userId, updatedUser);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {
        try {
            User user = userService.login(request);
            // Usando UserResponseDTO para retornar apenas informações seguras
            UserResponseDTO response = new UserResponseDTO(user.getUserId(), user.getUserName(), user.getUserEmail());
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }


    // Encontrar user através do id
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        User user = userService.findUserById(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
