package com.manik.recipeee.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.manik.recipeee.config.JwtProvider;
import com.manik.recipeee.entities.User;
import com.manik.recipeee.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User findUserById(Long id) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        throw new Exception("User not found with id: " + id);
    }

    @Override
    public User findUserByJwt(String jwt) throws Exception {
        String email = jwtProvider.getEmailFromJwtToken(jwt);
        if (email == null) {
            throw new IllegalArgumentException("Please provide a valid JWT token.");
        }
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new Exception("User not found with email: " + email);
        }
        return user;
    }
}