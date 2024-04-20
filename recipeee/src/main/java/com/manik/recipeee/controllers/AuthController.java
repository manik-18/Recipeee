package com.manik.recipeee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.manik.recipeee.Request.LoginRequest;
import com.manik.recipeee.Response.AuthResponse;
import com.manik.recipeee.config.JwtProvider;
import com.manik.recipeee.entities.User;
import com.manik.recipeee.repositories.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public AuthResponse createUser(@RequestBody User user) throws Exception {
        String email = user.getEmail();
        String password = user.getPassword();
        String fullName = user.getName();
        String imageUrl = user.getImageUrl();
        User existingUser = userRepository.findByEmail(email);
        if (existingUser != null) {
            throw new Exception("Email is already used with another account");
        }
        User createdUser = new User();
        createdUser.setName(fullName);
        createdUser.setEmail(email);
        createdUser.setPassword(passwordEncoder.encode(password));
        createdUser.setImageUrl(imageUrl);
        userRepository.save(createdUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(email, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        AuthResponse res = new AuthResponse();
        res.setJwt(token);
        res.setMessage("Signup success");
        return res;
    }

    @PostMapping("/signin")
    public AuthResponse signinHandler(@RequestBody LoginRequest loginRequest) throws Exception {
        String username = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        User user = userRepository.findByEmail(username);
        if(user==null){
            throw new Exception("User not found");
        }
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new Exception("Invalid Password");
        }
        Authentication authentication =new UsernamePasswordAuthenticationToken(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        AuthResponse res = new AuthResponse();
        res.setJwt(token);
        res.setMessage("Signin success");
        return res;
    }
}