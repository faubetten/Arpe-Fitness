package pt.iade.ArpeFitness.models.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pt.iade.ArpeFitness.models.tables.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM users WHERE user_name = :name", nativeQuery = true)
    Iterable<User> findUserByName(@Param("name") String name);
    
}
