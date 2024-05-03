package com.grl.TFG_API.services;

import com.grl.TFG_API.model.dto.NewUserDTO;
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
        User output = new User();
        var user = repository.getUserByGmailAndPassword(gmail, password);
        if (user != null) {
            output = user;
        }
        return output;
    }

    public User saveNewUser(NewUserDTO newUser) {
        var output = new User();
        if(!repository.existsByGmail(newUser.gmail())){
            output = repository.save(convertNewUserDTOIntoUser(newUser));
        }
        return output;
    }

    private User convertNewUserDTOIntoUser(NewUserDTO newUserDTO) {
        User user = new User();
        user.setName(newUserDTO.name());
        user.setAddress(newUserDTO.address());
        user.setPassword(newUserDTO.password());
        user.setPhone(newUserDTO.phone());
        user.setGmail(newUserDTO.gmail());
        return user;
    }
}