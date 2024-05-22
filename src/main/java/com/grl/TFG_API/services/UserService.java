package com.grl.TFG_API.services;

import com.grl.TFG_API.model.dto.NewUserDTO;
import com.grl.TFG_API.model.entity.User;
import com.grl.TFG_API.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;
    private final DTOTransformationService transformator;

    @Autowired
    public UserService(UserRepository repository, DTOTransformationService transformator) {
        this.repository = repository;
        this.transformator = transformator;
    }

    public User getByCredentials(String gmail, String password) {
        User output = new User();
        var user = repository.getUserByGmailAndPassword(gmail, password);
        if (user != null) {
            output = user;
            output.setOrders(null);
        }
        return output;
    }

    public User saveNewUser(NewUserDTO newUser) {
        var output = new User();
        if(!repository.existsByGmail(newUser.gmail())){
            output = repository.save(transformator.convertNewUserDTOIntoUser(newUser));
        }
        return output;
    }
}