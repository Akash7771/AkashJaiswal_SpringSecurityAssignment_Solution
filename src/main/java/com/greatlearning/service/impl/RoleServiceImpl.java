package com.greatlearning.service.impl;

import com.greatlearning.entities.Role;
import com.greatlearning.repositories.RoleRepository;
import com.greatlearning.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    @Transactional
    public Integer save(Role role) {
        Role role1 = roleRepository.save(role);
        return role1.getId();
    }

    @Override
    public Role findById(Integer id) {
        return roleRepository.findById(id).orElse(null);
    }
}
