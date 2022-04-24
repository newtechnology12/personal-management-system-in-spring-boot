package com.manager.information.controller;


import com.manager.information.ActivityType;
import com.manager.information.domain.Activity;
import com.manager.information.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ActivityControllerUI {
    @Autowired
    private IActivityService activityService;

    @GetMapping("/viewActivity")
    public String activityList(Model model){
        model.addAttribute("activities",activityService.findAllActivity());
        model.addAttribute("EActivity", ActivityType.values());
        return "activity/activityForm";
    }
    @PostMapping("/registrationActivity")
    public String activityRegistration(Model model){
        Activity activity = new Activity();
        model.addAttribute("activity", activity);
        model.addAttribute("EActivity",ActivityType.values());
        return "activityForm";
    }
    @PostMapping("/save")
    public String saveActivity(@ModelAttribute("activity") Activity activity,Model model){
        model.addAttribute("EActivity",ActivityType.values());
        activityService.createActivity(activity);

        return "redirect:/viewActivity";


    }
}
