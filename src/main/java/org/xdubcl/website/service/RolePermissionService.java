package org.xdubcl.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xdubcl.website.model.Role;
import org.xdubcl.website.model.RolePermission;
import org.xdubcl.website.repository.RolePermissionRepository;

import java.util.List;

@Service
public class RolePermissionService {

    @Autowired
    RolePermissionRepository rolePermissionRepository;
    public List<RolePermission> findAllByRole(Role role){
        int rid = role.getId();
        return rolePermissionRepository.findAllByRid(rid);
    }

}



