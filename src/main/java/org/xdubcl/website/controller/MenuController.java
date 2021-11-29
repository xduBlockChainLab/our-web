package org.xdubcl.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdubcl.website.model.*;
import org.xdubcl.website.service.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MenuController {
    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    RolePermissionService rolePermissionService;
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;

    @GetMapping("/api/permission")
    public List<Permission> permission(String username) {

        User user = userService.findByEmail(username);
        List<UserRole> userRoles = userRoleService.findRolesByUser(user);

        List<Permission> permissions = new ArrayList<>();
        for (UserRole userRole : userRoles) {
            Role role = roleService.findRolesById(userRole.getRid());
            List<RolePermission> rolePermissions = rolePermissionService.findAllByRole(role);

            for (RolePermission rolePermission : rolePermissions) {
                Permission permission = permissionService.findPermissionById(rolePermission.getPid());
                permissions.add(permission);
            }
        }
        return permissions;
    }
}
