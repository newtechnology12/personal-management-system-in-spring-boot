package com.manager.information.service;

import com.manager.information.ActivityType;
import com.manager.information.domain.Activity;

import java.util.Date;
import java.util.List;


public interface IActivityService {
    Activity createActivity(Activity activity);

    List<Activity> findAllActivity();

    Activity findById(Long id);
    Activity findByDate(Date date);
    Activity findBYName(ActivityType activityName);

    Activity updateActivity(Activity activity);

    void deleteById(Long id);
}
