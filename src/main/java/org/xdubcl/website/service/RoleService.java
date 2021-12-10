package org.xdubcl.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.xdubcl.website.model.Role;
import org.xdubcl.website.repository.RoleRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public abstract class RoleService extends JdbcDaoSupport implements RoleRepository {
    @Autowired
    RoleRepository roleRepository;
    public Role findRolesById(int rid){
        return roleRepository.findById(rid);
    }
    @Transactional
    public boolean isRoleExist(String roleName){
        String sql = "SELECT COUNT(*) FROM ROLE where NAME=?";
        int count = getJdbcTemplate().queryForObject(sql,new Object[]{roleName},Integer.class);

        if(count >=1) return true;
        return false;
    }
}
