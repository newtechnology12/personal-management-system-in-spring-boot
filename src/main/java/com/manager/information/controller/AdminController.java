package com.manager.information.controller;

import com.manager.information.domain.User;
import com.manager.information.repository.RoleRepository;
import com.manager.information.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private UserServices userService;

    @Autowired
    private RoleRepository roleService;


    @GetMapping("/users?={role}")
    public List<User> getUsers(@RequestParam int role){
        return null;
    }


}
