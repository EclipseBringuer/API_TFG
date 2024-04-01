package com.grl.TFG_API.services;

import com.grl.TFG_API.model.entity.User;
import com.grl.TFG_API.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getByCredentials(String gmail, String password) {
        return repository.getUserByGmailAndPassword(gmail, password);
    }
}