package com.producttask.task.repository;

import com.producttask.task.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("""
    SELECT  u FROM User u where u.username = :username
""")
    Optional<User> findUserByUsername(String username);
}
