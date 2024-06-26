package com.manik.recipeee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.manik.recipeee.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
