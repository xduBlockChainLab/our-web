package org.xdubcl.website.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xdubcl.website.model.Role;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    abstract Role findById(int id);
    public List<Role> findAllByRolename(String roleName);
    public void deleteByRolename(String roleName);
    public boolean isRoleExist(String roleName);

}
