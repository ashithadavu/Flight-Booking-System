package com.capg.userservice.security.Service;

import com.capg.userservice.entity.UsersData;
import com.capg.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class MyUserDetailsService implements UserDetailsService {
	
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        List<SimpleGrantedAuthority> roles = null;
        Optional<UsersData> userData = userRepository.getUserDataByEmail(name);
        if (userData == null) {
            throw new UsernameNotFoundException(name);
        }
        else {
                //checking for admin Role
                if (name.contains("admin"))
                {
                    roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
                    return new User("admin", "admin", roles);
                }
                //checking for User Role
                else
                {
                    String username = userData.get().getEmail();
                    String password = userData.get().getPassword();
                    roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
                    return new User(username, password, roles);
                }
        }
    }
}
