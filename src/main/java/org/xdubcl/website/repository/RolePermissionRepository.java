package org.xdubcl.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xdubcl.website.model.RolePermission;

import java.util.List;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission,Integer> {
    List<RolePermission> findAllByRid(int rid);
}
