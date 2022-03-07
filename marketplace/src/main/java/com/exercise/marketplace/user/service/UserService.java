package com.exercise.marketplace.user.service;

import java.util.Optional;

import com.exercise.marketplace.user.model.UserInfo;
import com.exercise.marketplace.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service("userService")
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    /*
     * Get User Info From Database using JPA
     */
    public ResponseEntity<UserInfo> getUserInfo(@PathVariable("user_id") long user_id) {
        
        Optional<UserInfo> user = userRepository.findById(user_id);
        if(user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public UserInfo getUser(String user_id) {
        ResponseEntity<UserInfo> userByDatabase = getUserInfo(Long.parseLong(user_id));
        System.out.println(Long.parseLong(user_id));
        if(userByDatabase.getStatusCode() == HttpStatus.NOT_FOUND) {
            return null;
        }

        return userByDatabase.getBody();
    }
}
