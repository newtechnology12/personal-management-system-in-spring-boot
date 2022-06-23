package com.manager.information.controller;

import com.manager.information.domain.Activity;
import com.manager.information.domain.ActivityType;
import com.manager.information.domain.User;
import com.manager.information.repository.UserRepository;
import com.manager.information.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.List;


@Controller
public class ActivityControllerUI {
    @Autowired
    private IActivityService activityService;
    @Autowired
    private UserRepository userService;
    @CrossOrigin
    @GetMapping("/viewActivity")
    public String userActivtiy(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("activity",activityService.findAllActivity());
        model.addAttribute("EActivity",ActivityType.values());
        model.addAttribute("totalAmount",activityService.totalAmount());
        return "activity/activityUser";

    }

    // new form for student
    @RequestMapping("/activityForm")
    public String CreateActivityForm(Model model) {
        model.addAttribute("activity", new Activity());
        model.addAttribute("EActivity", ActivityType.values());
        return "activity/registration";
    }
    //	update student from page
    @GetMapping("/students/edit/{id}")
    public ModelAndView DesplayStudent(@PathVariable(value = "id") Long id, Model model) {
        ModelAndView modelAndView = new ModelAndView("activity/registration");
        model.addAttribute("EActivity", ActivityType.values());
        Activity existingStudent = activityService.findById(id);
        modelAndView.addObject("activity", existingStudent);
        return modelAndView;

    }

    @CrossOrigin
    @GetMapping("/userDashboard")
    public String dashBoadUser(){
        return "starter";
    }

    //Save new student where "student" has student details information id,name..
    @PostMapping("/activityRegistration")
    public String saveActivity(@Valid @ModelAttribute("activity") Activity activity, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("EActivity", ActivityType.values());
            return "activity/DisplayAllActivities";

        } else {
            activityService.createActivity(activity);
            return "redirect:/userDashboard";

        }


    }

    @GetMapping("/showFormForUpdateStudent/{id}")
    public ModelAndView DesplayActivity(@PathVariable(value = "id") Long id, Model model) {
        ModelAndView modelAndView = new ModelAndView("activity/newCreateActivity");
        model.addAttribute("EActivity", ActivityType.values());
        model.addAttribute("listUsers", userService.findAll());
        Activity existingActivity = activityService.findById(id);
        modelAndView.addObject("activity", existingActivity);
        return modelAndView;
    }

    @CrossOrigin
    @GetMapping("/deleteActivity/{id}")
    public String removeStudent(@PathVariable(value = "id") Long actId) {
        activityService.deleteById(actId);
        return "redirect:/viewActivity";
    }
}







