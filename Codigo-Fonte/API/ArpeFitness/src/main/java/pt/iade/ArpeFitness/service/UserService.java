package pt.iade.ArpeFitness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pt.iade.ArpeFitness.dto.LoginRequestDTO;
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
    public String createUserInitial(User user) {
        // Verifica se o email já existe no banco de dados
        if (userRepository.findByUserEmail(user.getUserEmail()).isPresent()) {
            return "Erro: Email já cadastrado.";
        }

        // Criptografa a senha antes de salvar
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));

        // Verifica se userGoal e userExperience estão presentes
        if (user.getUserGoal() == null || user.getUserExperience() == null) {
            return "Erro: Meta e experiência do usuário são obrigatórias.";
        }

        // Salva o usuário no banco
        userRepository.save(user);
        return "Usuário criado com sucesso.";
    }

    // Método para login com verificação de email e senha
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

    // Método para atualizar informações adicionais do usuário
    public User updateUserInfo(Integer userId, User updatedUser) {
        // Busca o usuário pelo ID
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        // Atualiza as informações
        user.setUserBirthDate(updatedUser.getUserBirthDate());
        user.setUserGender(updatedUser.getUserGender());
        user.setUserHeight(updatedUser.getUserHeight());
        user.setUserWeight(updatedUser.getUserWeight());

        // Adicione as atualizações de userGoal e userExperience
        if (updatedUser.getUserGoal() != null) {
            user.setUserGoal(updatedUser.getUserGoal());
        }

        if (updatedUser.getUserExperience() != null) {
            user.setUserExperience(updatedUser.getUserExperience());
        }

        return userRepository.save(user);
    }

    // Método para buscar um usuário pelo ID
    public User findUserById(Integer userId) {
        return userRepository.findByUserId(userId).orElse(null);
    }
}
