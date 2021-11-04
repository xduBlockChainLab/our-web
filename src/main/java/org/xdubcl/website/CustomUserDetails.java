package org.xdubcl.website;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private User user;

    public CustomUserDetails(User user) {
        this.user=user;
    }


    public Collection<? extends GrantedAuthority> getAuthorities(){
        return null;
    }

    public String getPassword(){
        return user.getPassword();
    }

    public String getUsername(){
        return user.getEmail();
    }

    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired(){
        return true;
    }

    public boolean isEnabled(){
        return true;
    }

    public String getFullName(){
        return user.getFirstName()+" "+user.getLastName();
    }


}
