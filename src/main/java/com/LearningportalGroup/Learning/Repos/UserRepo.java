package com.LearningportalGroup.Learning.Repos;

import com.LearningportalGroup.Learning.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User , Integer> {
}
