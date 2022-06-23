package com.manager.information.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

import java.util.Collection;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "userRegistration",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "personType")
    @Enumerated(EnumType.STRING)
    private TitleType personType;
    @Column(name = "userName")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    private Boolean active;
    @Column(name = "reset_token")
    private String resetToken;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userRegistration")
    @JsonBackReference
    private Set<Activity> activities;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String firstName, String lastName, TitleType personType, String userName, String email, String password, Boolean active, String resetToken,Set<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personType = personType;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.active = active;
        this.resetToken = resetToken;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public TitleType getPersonType() {
        return personType;
    }

    public void setPersonType(TitleType personType) {
        this.personType = personType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}



