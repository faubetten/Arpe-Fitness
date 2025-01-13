package pt.iade.ArpeFitness.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iade.ArpeFitness.models.tables.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserEmail(String userEmail);
}
