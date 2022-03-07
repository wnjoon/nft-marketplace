package com.exercise.marketplace.user.repository;

// import java.util.List;

import com.exercise.marketplace.user.model.UserInfo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
    // List<UserInfo> findByUsername(String username);
}
