package com.manager.information.implement;

import com.manager.information.ActivityType;
import com.manager.information.domain.Activity;
import com.manager.information.domain.TitleType;
import com.manager.information.domain.UserRegistration;
import com.manager.information.repository.IActivityRep;
import com.manager.information.repository.IUserRegistrationRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class UserRegistrationImplement implements CommandLineRunner {
    @Autowired
    private IUserRegistrationRep userRegistrationRep;
    @Autowired
    private IActivityRep activityRep;

    public UserRegistrationImplement(IUserRegistrationRep userRegistrationRep, IActivityRep activityRep) {
        this.userRegistrationRep = userRegistrationRep;
        this.activityRep = activityRep;
    }

    @Override
    public void run(String... args) throws Exception {
        UserRegistration user = new UserRegistration("celestin", TitleType.DRIVER,"celestmanai","celestin@gmail.com","kigali");
        Activity act1 = new Activity(LocalDate.of(2022,04,23), ActivityType.GAZ,5000,"I bought gaz from Russia",user);
        Activity act2 = new Activity(LocalDate.of(2022,04,22),ActivityType.RESTAURANT,2000,"I have eaten a fancy Restaurant",user);

        activityRep.save(act1);
        activityRep.save(act2);


        UserRegistration user2 = new UserRegistration("karake",TitleType.TOURIST,"kaarakenana","karakenana@gmail.com","rwanda");
        //user.getActivities().add(act1);
        //user.getActivities().add(act2);

        //c1.getStudents().add(student1);
//student1.getCourses().add(c3);
//courseRep.save(c3);
        userRegistrationRep.save(user);
        userRegistrationRep.save(user2);



        System.out.println("The number of  UserRegistration are  : "+ userRegistrationRep.count());
        System.out.println("the number of activity are  : " + activityRep.count());
    }
}
