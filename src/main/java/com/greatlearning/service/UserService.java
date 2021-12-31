package com.greatlearning.service;

import com.greatlearning.entities.User;

public interface UserService {

    public Integer save(User user);
    public User findById(Integer userId);

}
