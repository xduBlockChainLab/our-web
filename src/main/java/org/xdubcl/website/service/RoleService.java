package org.xdubcl.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.xdubcl.website.model.Role;
import org.xdubcl.website.repository.RoleRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleService{
    @Autowired
    RoleRepository roleRepository;
    public Role findRolesById(int id){
        return roleRepository.findById(id);
    }

}
