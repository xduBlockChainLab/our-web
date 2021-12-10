package org.xdubcl.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.xdubcl.website.model.Permission;
import org.xdubcl.website.model.Role;
import org.xdubcl.website.model.User;
import org.xdubcl.website.repository.PermissionRepository;
import org.xdubcl.website.repository.RoleRepository;
import org.xdubcl.website.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

public class ModelService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;

    @Transactional
    public void deleteUser(String userName){
        List<User> users = userRepository.findAllByUsername(userName);
        //如果删除维护端数据，只是把维护端的List清空
        for(User user : users){
            user.getRoles().clear();
            userRepository.save(user);
        }
        userRepository.deleteByUsername(userName);
    }

    @Transactional
    public void deleteRole(String roleName){
        List<Role> roles = roleRepository.findAllByRolename(roleName);
        List<User> users = (List<User>) userRepository.findAll();
        for(User user:users){
            List<Role> userRole = user.getRoles();
            for(Role role:roles){
                if(userRole.contains(role)){
                    userRole.remove(role);
                }
                role.getPermissions().clear();
                roleRepository.save(role);
            }
            userRepository.save(user);
        }
        roleRepository.deleteByRolename(roleName);
    }

    @Transactional
    public void deletePermission(String permissionName){
        List<Permission> permissions = permissionRepository.findAllByPermissionname(permissionName);
        List<Role> roles = roleRepository.findAll();
        //若删除被维护端的数据，则把用户（维护端）地List中要移除的角色都remove
        for(Role role:roles){
            List<Permission> rolePermission = role.getPermissions();
            for(Permission permission:permissions){
                if(rolePermission.contains(permission)){
                    rolePermission.remove(permission);
                }
            }
            roleRepository.save(role);
        }
        permissionRepository.deleteByPermissionname(permissionName);
    }

}


