package me.travisgray.Security;


import me.travisgray.Entity.*;
import me.travisgray.Repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by student on 6/28/17.
 */
public class SSUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployerRepository employerRepository;
    private CandidateResumeRepository candidateResumeRepository;
    private CandidateRepository candidateRepository;
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private UserRole userRole;

    public SSUserDetailsService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException{
        try{
            UserData user = userRepository.findByUsername(username);
            if(user == null){
                return null;
            }
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    getAuthorities(user));
        }   catch (Exception e){
            throw new UsernameNotFoundException("User not found");
        }
    }

    private Set<GrantedAuthority> getAuthorities(UserData user){
        Set<GrantedAuthority> authorities
                = new HashSet<GrantedAuthority>();
        for(UserRole role : user.getRoles()){
            GrantedAuthority grantedAuthority
                    = new SimpleGrantedAuthority(role.getRole());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }

}


