package org.xdubcl.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xdubcl.website.model.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,Integer> {
    Permission findById(int id);
}
