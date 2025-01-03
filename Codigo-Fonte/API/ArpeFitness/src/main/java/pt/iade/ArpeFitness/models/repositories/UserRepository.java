package pt.iade.ArpeFitness.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iade.ArpeFitness.models.tables.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    // Este método irá buscar o usuário pelo ID
    Optional<User> findById(Integer userId);

    // Caso você precise de métodos personalizados, como por exemplo, por nome ou email:
    Optional<User> findByEmail(String email);
}
