package com.manager.information.controller;

import com.manager.information.domain.TitleType;
import com.manager.information.domain.UserRegistration;
import com.manager.information.repository.IUserRegistrationRep;
import com.manager.information.service.IUserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRegistrationController {
    @Autowired
    private IUserRegistrationService userRegistrationService;

//    @RequestMapping(value = "/userList")
//    public List<UserRegistration> getAlUser() {
//        List<UserRegistration> userRegistrations = new ArrayList<>();
//        userRegistrations.add(new UserRegistration("Albert", TitleType.BUSINESS_MAN, "albert12", "sentongoalbert@gmail.com", "magufuri", null));
//        return userRegistrations;
//    }

    @PostMapping(value = "/createUSerRegistration")
    public UserRegistration addUser(@RequestBody UserRegistration userRegistration) {
        UserRegistration user = new UserRegistration();
        user.setNames(userRegistration.getNames());
        user.setUserName(userRegistration.getUserName());
        user.setEmail(userRegistration.getEmail());
        user.setPersonType(user.getPersonType());
        user.setPassword(user.getPassword());
        return userRegistrationService.createUserRegistration(user);

    }


}
