package com.manager.information.domain;

import com.manager.information.ActivityType;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "Activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "nameOfActivity")
    @Enumerated(EnumType.STRING)
    private ActivityType nameOfActivity;
    @Column(name = "amount")
    private double amount;
    @Column(name = "comment")
    private String comment;
    @ManyToOne(fetch = FetchType.LAZY)
    private UserRegistration userRegistration;

    public Activity() {
    }



    public Activity(LocalDate date, ActivityType nameOfActivity, double amount, String comment, UserRegistration userRegistration) {
        this.date = date;
        this.nameOfActivity = nameOfActivity;
        this.amount = amount;
        this.comment = comment;
        this.userRegistration = userRegistration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ActivityType getNameOfActivity() {
        return nameOfActivity;
    }

    public void setNameOfActivity(ActivityType nameOfActivity) {
        this.nameOfActivity = nameOfActivity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public UserRegistration getUserRegistration() {
        return userRegistration;
    }

    public void setUserRegistration(UserRegistration userRegistration) {
        this.userRegistration = userRegistration;
    }
}
