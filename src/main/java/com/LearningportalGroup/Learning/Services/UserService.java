package com.LearningportalGroup.Learning.Services;

import com.LearningportalGroup.Learning.Exceptions.UserNotFoundException;
import com.LearningportalGroup.Learning.Models.User;
import com.LearningportalGroup.Learning.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User getUser(int id){
        return userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));

    }

}
