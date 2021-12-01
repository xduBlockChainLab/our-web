package org.xdubcl.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.xdubcl.website.model.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {

    @Query("SELECT u FROM  User u WHERE u.email= ?1")
    User findByEmail(String email);
    public List<User> findAllByUsername(String userName);
    public void deleteByUsername(String userName);
}
