package com.exercise.marketplace.user.repository;

import com.exercise.marketplace.user.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
}
