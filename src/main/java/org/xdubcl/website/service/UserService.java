package org.xdubcl.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xdubcl.website.model.User;
import org.xdubcl.website.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}