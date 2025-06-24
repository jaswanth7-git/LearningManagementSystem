package com.LearningportalGroup.Learning.Services;

import com.LearningportalGroup.Learning.Exceptions.DTOs.RequestDTOs.UserUpdateDTO;
import com.LearningportalGroup.Learning.Exceptions.InvalidRequestException;
import com.LearningportalGroup.Learning.Exceptions.UserNotFoundException;
import com.LearningportalGroup.Learning.Models.User;
import com.LearningportalGroup.Learning.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User getUser(int id){
        return userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));

    }

    public User postUser(User user) {
        if(!userRepo.existsById(user.getUserId())){
            userRepo.save(user);
        }
        else{
            throw new InvalidRequestException("User Already exist with this Id "+user.getUserId());
        }
        return user;
    }

    public UserUpdateDTO updateUser(UserUpdateDTO user , int id) {
        if(user == null || !userRepo.existsById(id)){
            throw new UserNotFoundException("User with this id does not exist user id : "+id);
        }else{
            User existinguser = userRepo.findById(id).get();
            existinguser.setEmail(user.getEmail());
            existinguser.setName(user.getName());
            userRepo.save(existinguser);
            return user;
        }
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public void deleteUser(int id) {
        if(!userRepo.existsById(id)){
           throw new UserNotFoundException("User not found ID : "+id);
        }
        userRepo.deleteById(id);
    }
}
