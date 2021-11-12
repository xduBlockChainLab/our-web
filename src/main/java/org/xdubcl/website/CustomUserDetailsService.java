package org.xdubcl.website;

import com.example.demo.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repo;
    @Override
    public CustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user =repo.findByEmail(email);
        if(user==null){
            throw new UsernameNotFoundException("User not Found");
        }
        return new com.example.demo.CustomUserDetails(user);
    }
}
