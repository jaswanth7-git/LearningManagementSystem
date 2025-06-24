package com.LearningportalGroup.Learning.Controllers;

import com.LearningportalGroup.Learning.Exceptions.DTOs.RequestDTOs.UserUpdateDTO;
import com.LearningportalGroup.Learning.Models.User;
import com.LearningportalGroup.Learning.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/lms/user")
@RestController
public class Usercontroller
{
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<?> getUser(@RequestParam("id") int id){
            User user = userService.getUser(id);
            return ResponseEntity.ok(user);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllusers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<?>postUser(@RequestBody User user){
        User newuser = userService.postUser(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>updateUser(@RequestBody UserUpdateDTO user , @PathVariable int id){
        UserUpdateDTO newuser = userService.updateUser(user,id);
        return ResponseEntity.ok(newuser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
