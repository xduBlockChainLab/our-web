package com.example.demo1;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
//    public User findById(Long id);
    //@Query("SELECT u FROM User WHERE u.email = ?1")
    User findByEmail(String email);

}

