package com.manager.information.controller;

import com.manager.information.domain.Activity;
import com.manager.information.domain.ActivityType;
import com.manager.information.domain.TitleType;
import com.manager.information.domain.User;
import com.manager.information.repository.UserRepository;
import com.manager.information.service.IActivityService;

import com.manager.information.service.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class HomeMainController {
    @Autowired
    private UserRepository userRegistrationService;
    @Autowired
    private IActivityService activityService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserServices userService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/about")
    public String getAbout(){
        return "about";
    }
    @GetMapping("/ShowTestimonial")
    public String viewTestimonial(){
        return "testimonial";
    }
    @GetMapping("/starter")
    public String viewStarter(){
        return "starter";
    }
    @GetMapping("/book")
    public String viewBook(){
        return "book";
    }
    @GetMapping("/")
    public String home(Model model){
        return "index";
    }


    @RequestMapping("/api-registeruser")
    public String CreateActivityForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("ETitleType", TitleType.values());
        return "/registration";
    }

    @PostMapping("/process_register")
    public String processRegister(User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "register_successfully";

    }


    @GetMapping("/admin")
    public String homeAdmin(Model model) {
        model.addAttribute("users", userRegistrationService.findAll());
        model.addAttribute("ETitle", TitleType.values());
        model.addAttribute("activities", activityService.findAllActivity());
        model.addAttribute("EActivityType", ActivityType.values());
        model.addAttribute("usersAccount", userRegistrationService.findAll().size());
        model.addAttribute("activityAccount", activityService.findAllActivity().size());
        List<User> userRegistrations = userRegistrationService.findAll();
        List<Activity> activities = activityService.findAllActivity();


        List<Enum> activityNames = new ArrayList<>();
        for (Activity act : activities) {
            activityNames.add(act.getNameOfActivity());
        }
        List<Integer> numberOfUserRegistered = new ArrayList<>();
        for (User userRegistration : userRegistrations) {
            numberOfUserRegistered.add(userRegistration.getActivities().size());
        }
        model.addAttribute("userRegistered",numberOfUserRegistered);
        model.addAttribute("activityName",activityNames);
        return "admin/adminpage";
    }
    @GetMapping("/api/admin")
    public  String useradmindashboard(){

        return "adminpage";
    }
    @GetMapping("/test")
    public String EditProfile(Authentication auth, Model model){
        String findUserName = auth.getName();
        User userRegistration = userRegistrationService.findByEmail(findUserName);
        if (userRegistration == null){
            logger.error("This UserName couldn't not found please check out userName perfectly!!");
        }
        model.addAttribute("userLogged",userRegistration);
        return "EditProfile";


    }
    @GetMapping(value="/admin/home")
    public ModelAndView homes(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getUserName() + "/" + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }

}
