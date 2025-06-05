package com.LearningportalGroup.Learning.Controllers;

import com.LearningportalGroup.Learning.Models.User;
import com.LearningportalGroup.Learning.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<?>postUser(@RequestBody User user){
        User newuser = userService.postUser(user);
        return ResponseEntity.ok(user);
    }
}
