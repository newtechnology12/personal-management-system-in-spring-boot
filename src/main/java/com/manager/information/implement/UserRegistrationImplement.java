//package com.manager.information.implement;
//
//import com.manager.information.domain.*;
//import com.manager.information.repository.IActivityRep;
//import com.manager.information.repository.RoleRepository;
//import com.manager.information.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//
//
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.Set;
//
//@Component
//public class UserRegistrationImplement implements CommandLineRunner {
//    @Autowired
//    private UserRepository registrationRep;
//    @Autowired
//    private RoleRepository repository;
//    @Autowired
//    private IActivityRep activityRep;
//    @Override
//    public void run(String... args) throws Exception {
//        Role role = new Role("USER");
//        Role admin = new Role("ADMIN");
//        repository.save(role);
//        repository.save(admin);
//        User userRegistration = new User ("celestin","albert", TitleType.TOURIST,"celestin12","celestin@gmail.com","MAGUFURI", true, "NGVBDFYRTSE456M98", Set.of(role));
//        Activity activity = new Activity(LocalDate.of(2022,05,07), ActivityType.RESTAURANT,20000,"I was town",
//        userRegistration);
//        activityRep.save(activity);
//        registrationRep.save(userRegistration);
//
//        System.out.println("the number of user are : " +registrationRep.count());
//        System.out.println("the number of user are : " + activityRep.count());
//        System.out.println("the number of user are : " + repository.count());
//
//    }
//}
