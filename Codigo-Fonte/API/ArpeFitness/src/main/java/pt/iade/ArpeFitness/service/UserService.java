package pt.iade.ArpeFitness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pt.iade.ArpeFitness.dto.UserRequestDTO;
import pt.iade.ArpeFitness.dto.UserResponseDTO;
import pt.iade.ArpeFitness.models.enums.UserExperience;
import pt.iade.ArpeFitness.models.enums.UserGoal;
import pt.iade.ArpeFitness.models.repositories.UserRepository;
import pt.iade.ArpeFitness.models.tables.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Criar usuário inicial
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        if (userRepository.findByUserEmail(userRequestDTO.getUserEmail()).isPresent()) {
            throw new IllegalArgumentException("Erro: Email já cadastrado.");
        }

        User user = new User();
        user.setUserName(userRequestDTO.getUserName());
        user.setUserEmail(userRequestDTO.getUserEmail());
        user.setUserPassword(passwordEncoder.encode(userRequestDTO.getUserPassword()));

        // Salvar o usuário inicial
        User savedUser = userRepository.save(user);

        return new UserResponseDTO(
                savedUser.getUserId(),
                savedUser.getUserName(),
                savedUser.getUserEmail()
        );
    }

    // Atualizar dados adicionais do usuário
    public UserResponseDTO updateUser(Integer userId, UserRequestDTO userRequestDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        // Atualizar os campos enviados pelo cliente
        if (userRequestDTO.getUserBirthDate() != null) user.setUserBirthDate(userRequestDTO.getUserBirthDate());
        if (userRequestDTO.getUserGender() != null) user.setUserGender(userRequestDTO.getUserGender());
        if (userRequestDTO.getUserHeight() != null) user.setUserHeight(userRequestDTO.getUserHeight());
        if (userRequestDTO.getUserWeight() != null) user.setUserWeight(userRequestDTO.getUserWeight());
        if (userRequestDTO.getUserGoal() != null) {
            // Converter string para enum UserGoal
            UserGoal goal = UserGoal.fromValue(userRequestDTO.getUserGoal());
            user.setUserGoal(goal);
        }
        if (userRequestDTO.getUserExperience() != null) {
            // Converter string para enum UserExperience
            UserExperience experience = UserExperience.fromValue(userRequestDTO.getUserExperience());
            user.setUserExperience(experience);
        }

        // Salvar o usuário atualizado
        User savedUser = userRepository.save(user);

        return new UserResponseDTO(
                savedUser.getUserId(),
                savedUser.getUserName(),
                savedUser.getUserEmail(),
                savedUser.getUserBirthDate(),
                savedUser.getUserGender(),
                savedUser.getUserHeight(),
                savedUser.getUserWeight(),
                savedUser.getUserGoal().getValue(),
                savedUser.getUserExperience().getExperience()
        );
    }
}
