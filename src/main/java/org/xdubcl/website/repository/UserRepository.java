package org.xdubcl.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.xdubcl.website.model.User;

public interface UserRepository extends CrudRepository<User,Long> {

    @Query("SELECT u FROM  User u WHERE u.email= ?1")
    User findByEmail(String email);
}
