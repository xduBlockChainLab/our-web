package org.xdubcl.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xdubcl.website.model.User;
import org.xdubcl.website.model.UserRole;
import org.xdubcl.website.repository.UserRoleRepository;

import java.util.List;

@Service
public class UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;
    public List<UserRole> findRolesByUser(User user){
        int uid = user.getId();
        return userRoleRepository.findAllByUid(uid);
    }
}
