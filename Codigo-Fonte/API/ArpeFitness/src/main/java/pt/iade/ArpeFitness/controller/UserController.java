package pt.iade.ArpeFitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
