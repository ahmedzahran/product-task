package com.producttask.task.service;

import com.producttask.task.repository.UserRepository;
import com.producttask.task.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var user = userRepository.findUserByUsername(username);
        return user.map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("username not found"));
    }
}
