package com.manager.information.controller;

import com.manager.information.domain.Activity;
import com.manager.information.domain.ActivityType;
import com.manager.information.domain.TitleType;
import com.manager.information.domain.User;

import com.manager.information.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/registration")
public class UserRegistrationControllerUI {
    @Autowired
    private UserRepository userRepository;


//    @GetMapping("/")
//    public String viewHomePage() {
//        return "index";
//    }

    @CrossOrigin
    @GetMapping("/viewUserRegister")
    public String getUserRegistration(Model model) {
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("ETitle", TitleType.values());
       return "registration";


    }
    @RequestMapping("/api-registeruser")
    public String CreateActivityForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("ETitleType", TitleType.values());
        return "/user/registration";
    }

    @PostMapping("/process_register")
    public String processRegister(User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "register_successfully";

    }
    @CrossOrigin
    @GetMapping("/showFormForUpdateUser/{id}")
    public ModelAndView DesplayActivity(@PathVariable(value = "id") Long id, Model model) {
        ModelAndView modelAndView = new ModelAndView("user/newUserRegistration");
        model.addAttribute("ETitle", TitleType.values());
        User existingUser = userRepository.getById(id);
        modelAndView.addObject("user",existingUser );
        return modelAndView;
    }
    @Autowired
    private UserRepository service;
    @RequestMapping(path = {"/","/search"})
    public String home(User shop, Model model, String keyword) {
        if(keyword!=null) {
            List<User> list = service.findByKeyword(keyword);
            model.addAttribute("list", list);
        }else {
            List<User> list = service.findAll();
            model.addAttribute("list", list);}
        return "user/displayAllUsers";
    }

    @GetMapping("/default")
    public String redirectAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ADMIN")) {
            return "redirect:/api/superAdmin";
        }else if(request.isUserInRole("USER")) {
            return "redirect:/";
        }else if(request.isUserInRole("SUPER_ADMIN")) {
            return "redirect:/api/admin";

        }else {
            return "redirect:/login";
        }

    }

}







