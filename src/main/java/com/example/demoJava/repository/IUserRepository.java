package com.example.demoJava.repository;

import com.example.demoJava.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE username = ?1")
    User findByUsername(String username);
}
