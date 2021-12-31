package com.greatlearning.service;

import com.greatlearning.entities.Role;

public interface RoleService {

    public Integer save(Role role);
    public Role findById(Integer id);
}
