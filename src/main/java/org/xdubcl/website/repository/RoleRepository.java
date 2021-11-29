package org.xdubcl.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xdubcl.website.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findById(int id);
}
