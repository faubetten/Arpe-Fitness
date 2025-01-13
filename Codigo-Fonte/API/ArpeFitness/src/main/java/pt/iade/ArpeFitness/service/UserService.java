package pt.iade.ArpeFitness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pt.iade.ArpeFitness.dto.LoginRequestDTO;
import pt.iade.ArpeFitness.dto.UserResponseDTO;
import pt.iade.ArpeFitness.models.repositories.UserRepository;
import pt.iade.ArpeFitness.models.tables.User;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Método para criar usuário com senha criptografada
    public UserResponseDTO createUser(User user) {
        if (userRepository.findByUserEmail(user.getUserEmail()).isPresent()) {
            throw new IllegalArgumentException("Erro: Email já cadastrado.");
        }

        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        User savedUser = userRepository.save(user);

        return new UserResponseDTO(
                savedUser.getUserId(),
                savedUser.getUserName(),
                savedUser.getUserEmail()
        );
    }

    public User login(LoginRequestDTO request) {
        // Verifica se o email existe no banco de dados
        Optional<User> userOptional = userRepository.findByUserEmail(request.getEmail());
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("Email não encontrado.");
        }
        User user = userOptional.get();
        // Verifica se a senha está correta
        if (!passwordEncoder.matches(request.getPassword(), user.getUserPassword())) {
            throw new IllegalArgumentException("Senha inválida.");
        }
        // Retorna o usuário autenticado
        return user;
    }

    // Método para atualizar usuário
    public UserResponseDTO updateUser(Integer userId, User updatedUser) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        if (updatedUser.getUserBirthDate() != null) {
            user.setUserBirthDate(updatedUser.getUserBirthDate());
        }
        if (updatedUser.getUserGender() != null) {
            user.setUserGender(updatedUser.getUserGender());
        }
        if (updatedUser.getUserHeight() != null) {
            user.setUserHeight(updatedUser.getUserHeight());
        }
        if (updatedUser.getUserWeight() != null) {
            user.setUserWeight(updatedUser.getUserWeight());
        }
        if (updatedUser.getUserGoal() != null) {
            user.setUserGoal(updatedUser.getUserGoal());
        }
        if (updatedUser.getUserExperience() != null) {
            user.setUserExperience(updatedUser.getUserExperience());
        }

        User savedUser = userRepository.save(user);
        return new UserResponseDTO(
                savedUser.getUserId(),
                savedUser.getUserName(),
                savedUser.getUserEmail(),
                savedUser.getUserBirthDate(),
                savedUser.getUserGender(),
                savedUser.getUserHeight(),
                savedUser.getUserWeight(),
                savedUser.getUserGoal(),
                savedUser.getUserExperience()
        );
    }

    // Método para buscar usuário pelo ID
    public User findUserById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
    }

    // Método para obter informações públicas do usuário
    public UserResponseDTO getUserInfo(Integer userId) {
        User user = findUserById(userId);

        return new UserResponseDTO(
                user.getUserId(),
                user.getUserName(),
                user.getUserEmail(),
                user.getUserBirthDate(),
                user.getUserGender(),
                user.getUserHeight(),
                user.getUserWeight(),
                user.getUserGoal(),
                user.getUserExperience()
        );
    }


}
