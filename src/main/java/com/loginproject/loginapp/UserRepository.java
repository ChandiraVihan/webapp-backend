package com.loginproject.loginapp;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Optional<User> findByGmailAndPassword(String gmail, String password);
     Optional<User> findByGmail(String gmail);

}
