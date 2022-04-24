package com.manager.information.repository;

import com.manager.information.ActivityType;
import com.manager.information.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface IActivityRep extends JpaRepository<Activity,Long>{
Activity findByDate(Date date);
Activity findByNameOfActivity(ActivityType activityType);
}


