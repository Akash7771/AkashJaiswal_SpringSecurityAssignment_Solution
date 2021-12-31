
package com.greatlearning.controller;

import com.greatlearning.entities.Role;
import com.greatlearning.entities.User;
import com.greatlearning.repositories.RoleRepository;
import com.greatlearning.repositories.UserRepository;
import com.greatlearning.service.RoleService;
import com.greatlearning.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@CrossOrigin
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/user" , method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<User> addUser(@RequestBody User user){

        Integer userId = userService.save(user);
        User response = userService.findById(userId);

        return new ResponseEntity(response , HttpStatus.CREATED );
    }

    @RequestMapping(value = "/role" , method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Role> addRole(@RequestBody Role role){
        Integer roleId = roleService.save(role);
        Role response = roleService.findById(roleId);
        return new ResponseEntity(response , HttpStatus.CREATED );
    }

}

