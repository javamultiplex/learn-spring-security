package com.github.javamultiplex.repositories;

import com.github.javamultiplex.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * @author Rohit Agarwal on 31/07/22 2:09 pm
 * @copyright github.com/javamultiplex
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("""
            SELECT u FROM User u WHERE u.username=:username
            """)
    Optional<User> findUserByUsername(String username);
}
