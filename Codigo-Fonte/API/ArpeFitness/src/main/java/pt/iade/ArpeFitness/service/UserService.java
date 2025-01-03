package pt.iade.ArpeFitness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pt.iade.ArpeFitness.models.repositories.UserRepository;
import pt.iade.ArpeFitness.models.tables.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUserInitial(User user) {
        // Aqui, o usuário só terá nome, email e senha
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }

        // Salvando o usuário parcialmente
        return userRepository.save(user);
    }

    public User updateUserInfo(Integer userId, User updatedUser) {
        // Atualiza as informações adicionais (data de nascimento, gênero, altura, peso)
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        user.setBirthDate(updatedUser.getBirthDate());
        user.setGender(updatedUser.getGender());
        user.setHeight(updatedUser.getHeight());
        user.setWeight(updatedUser.getWeight());

        return userRepository.save(user);
    }
}
