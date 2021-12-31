package com.greatlearning.service.impl;

import com.greatlearning.entities.Role;
import com.greatlearning.entities.User;
import com.greatlearning.repositories.UserRepository;
import com.greatlearning.service.RoleService;
import com.greatlearning.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleService roleService;

    @Override
    @Transactional
    public Integer save(User user) {
        log.info("USER : {}" ,
                user
        );
        List<Role> roles = new ArrayList<>();
        user.getRoles().stream().forEach(role -> {
            Role r = roleService.findById(role.getId());
            if(r!=null)
                roles.add(r);
        });

        User userToPersist = new User();
        userToPersist.setUsername(user.getUsername());
        userToPersist.setPassword(passwordEncoder( user.getPassword()) );
        userToPersist.setRoles(roles);

        User user1 = userRepository.save(userToPersist);

        return user1.getId();
    }

    @Override
    public User findById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    private String passwordEncoder(String password){
        return new BCryptPasswordEncoder().encode(password);
    }
}
