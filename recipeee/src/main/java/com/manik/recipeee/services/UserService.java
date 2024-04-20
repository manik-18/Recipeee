package com.manik.recipeee.services;

import com.manik.recipeee.entities.User;

public interface UserService {

    public User findUserById(Long id) throws Exception;

    public User findUserByJwt(String jwt) throws Exception;
}
