package com.grl.TFG_API.repositories;

import com.grl.TFG_API.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByGmailAndPassword(String gmail, String password);
}