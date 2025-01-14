package pt.iade.ArpeFitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.iade.ArpeFitness.dto.UserRequestDTO;
import pt.iade.ArpeFitness.dto.UserResponseDTO;
import pt.iade.ArpeFitness.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // 1. Endpoint para criar o usuário inicial
    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        try {
            UserResponseDTO response = userService.createUser(userRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // 2. Endpoint para atualizar dados adicionais
    @PutMapping("/{userId}/update")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Integer userId, @RequestBody @Valid UserRequestDTO userRequestDTO) {
        try {
            UserResponseDTO response = userService.updateUser(userId, userRequestDTO);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
