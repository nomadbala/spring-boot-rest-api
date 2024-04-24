package com.example.demo.Repository;

import com.example.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByLogin(String login);

    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.login = :login")
    void deleteUserByLogin(String login);
}
