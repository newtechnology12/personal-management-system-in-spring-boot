package com.manager.information.controller;

import com.manager.information.domain.TitleType;
import com.manager.information.service.IActivityService;
import com.manager.information.service.IUserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserRegistrationControllerUI {
    @Autowired
    private IUserRegistrationService userRegistrationService;
    @Autowired
    private IActivityService activityService;

    @GetMapping("/viewUserRegistration")
    public String getUserRegistration(Model model){
        model.addAttribute("users",userRegistrationService.findAllUserRegistration());
        model.addAttribute("Etitles", TitleType.values());
        model.addAttribute("activities",activityService.findAllActivity());
        return "user/userRegistration";

    }

}
