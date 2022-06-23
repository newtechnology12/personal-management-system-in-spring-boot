//package com.manager.information.controller;
//
//import com.manager.information.domain.User;
//import com.manager.information.service.UserServices;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.validation.Valid;
//
//@Controller
//public class LoginController {
//
//    @Autowired
//    private UserServices userService;
////
////    @GetMapping(value={"/login", "/loginn"})
////    public ModelAndView login(){
////        ModelAndView modelAndView = new ModelAndView();
////        modelAndView.setViewName("loginn");
////        return modelAndView;
////    }
////
////
////    @GetMapping(value="/registrations")
////    public ModelAndView registration(){
////        ModelAndView modelAndView = new ModelAndView();
////        User user = new User();
////        modelAndView.addObject("user", user);
////        modelAndView.setViewName("registrationn");
////        return modelAndView;
////    }
////
////    @PostMapping(value = "/registrations")
////    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
////        ModelAndView modelAndView = new ModelAndView();
////        User userExists = userService.findUserByUserName(user.getUserName());
////        if (userExists != null) {
////            bindingResult
////                    .rejectValue("userName", "error.user",
////                            "There is already a user registered with the user name provided");
////        }
////        if (bindingResult.hasErrors()) {
////            modelAndView.setViewName("registrationn");
////        } else {
////            userService.saveUser(user);
////            modelAndView.addObject("successMessage", "User has been registered successfully");
////            modelAndView.addObject("user", new User());
////            modelAndView.setViewName("registrationn");
////
////        }
////        return modelAndView;
////    }
//
////    @GetMapping(value="/admin/home")
////    public ModelAndView home(){
////        ModelAndView modelAndView = new ModelAndView();
////        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
////        User user = userService.findUserByUserName(auth.getName());
////        modelAndView.addObject("userName", "Welcome " + user.getUserName() + "/" + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
////        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
////        modelAndView.setViewName("admin/home");
////        return modelAndView;
////    }
//
//
//}