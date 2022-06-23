package com.manager.information.repository;

import com.manager.information.domain.Activity;
import com.manager.information.domain.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface IActivityRep extends JpaRepository<Activity,Long>{
Activity findByDate(Date date);
Activity findByNameOfActivity(ActivityType activityType);
//customer query selection from amount column
@Query(value = "select sum(amount) from Activity")
    public BigDecimal totalAmount();

    //Custom query
    @Query(value = "select * from Activity s where s.nameOfActivity like %:keyword%", nativeQuery = true)
    List<Activity> findByKeyword(@Param("keyword") String keyword);
}




