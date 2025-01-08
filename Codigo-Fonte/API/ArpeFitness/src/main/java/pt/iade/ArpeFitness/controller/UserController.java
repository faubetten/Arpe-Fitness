package pt.iade.ArpeFitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.iade.ArpeFitness.dto.LoginRequestDTO;
import pt.iade.ArpeFitness.models.tables.User;
import pt.iade.ArpeFitness.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint para cadastrar a primeira parte do usuário (nome, email, senha)
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUserInitial(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Endpoint para atualizar as informações do usuário após o cadastro (data de nascimento, gênero, etc)
    @PutMapping("/{userId}/update")
    public ResponseEntity<User> updateUserInfo(@PathVariable Integer userId, @RequestBody User updatedUser) {
        User updated = userService.updateUserInfo(userId, updatedUser);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // Endpoint para login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {
        try {
            User user = userService.login(request);
            return ResponseEntity.ok(user); // Retorna o usuário autenticado (ajuste conforme necessário)
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }



}
