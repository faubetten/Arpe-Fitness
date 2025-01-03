package pt.iade.ArpeFitness.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pt.iade.ArpeFitness.models.repositories.UserRepository;
import pt.iade.ArpeFitness.models.tables.User;


@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // Método para verificar as credenciais
    public boolean authenticate(String email, String password) {
        User user = userRepository.findByEmail(email).orElse(null);
        if (user != null) {
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;  // Caso não encontre o usuário
    }
}
