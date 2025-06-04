package com.LearningportalGroup.Learning.Controllers;

import com.LearningportalGroup.Learning.Models.User;
import com.LearningportalGroup.Learning.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
