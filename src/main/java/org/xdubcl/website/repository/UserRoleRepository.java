package org.xdubcl.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xdubcl.website.model.UserRole;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
    List<UserRole> findAllByUid(int uid);
}
