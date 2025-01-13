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

    // Endpoint para criação inicial do usuário
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody @Valid User user) {
        try {
            UserResponseDTO response = userService.createUser(user);

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (IllegalArgumentException e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Endpoint para atualizar informações adicionais do usuário
    @PutMapping("/{userId}/update")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Integer userId, @RequestBody @Valid UserResponseDTO userResponseDTO) {
        try {
            // Converte UserResponseDTO para User antes de chamar o serviço
            User updatedUser = new User();
            updatedUser.setUserName(userResponseDTO.getUserName());
            updatedUser.setUserEmail(userResponseDTO.getUserEmail());
            updatedUser.setUserBirthDate(userResponseDTO.getUserBirthDate());
            updatedUser.setUserGender(userResponseDTO.getUserGender());
            updatedUser.setUserHeight(userResponseDTO.getUserHeight());
            updatedUser.setUserWeight(userResponseDTO.getUserWeight());
            updatedUser.setUserGoal(userResponseDTO.getUserGoal());
            updatedUser.setUserExperience(userResponseDTO.getUserExperience());

            // Chama o método updateUser no serviço
            UserResponseDTO updatedResponse = userService.updateUser(userId, updatedUser);

            // Retorna a resposta com as informações atualizadas
            return ResponseEntity.ok(updatedResponse);
        } catch (RuntimeException e) {
            // Retorna um erro se o usuário não for encontrado
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Endpoint para autenticação do usuário (login)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequestDTO request) {
        try {
            // Chama o serviço para autenticar
            User user = userService.login(request);

            // Retorna uma resposta com os dados do usuário (sem senha)
            UserResponseDTO response = new UserResponseDTO(
                    user.getUserId(),
                    user.getUserName(),
                    user.getUserEmail()
            );
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    // Endpoint para buscar informações do usuário pelo ID
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Integer userId) {
        try {
            UserResponseDTO response = userService.getUserInfo(userId);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
