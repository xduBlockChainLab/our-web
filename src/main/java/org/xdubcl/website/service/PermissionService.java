package org.xdubcl.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xdubcl.website.model.Permission;
import org.xdubcl.website.repository.PermissionRepository;

@Service
public class PermissionService {
    @Autowired
    PermissionRepository permissionRepository;
    public Permission findPermissionById(int pid){
        return permissionRepository.findById(pid);
    }
}
