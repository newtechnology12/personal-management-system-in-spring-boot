package com.manager.information.domain;


import javax.persistence.*;
import java.util.HashSet;

import java.util.Set;

@Entity
@Table(name = "userRegistration")
public class UserRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "names")
    private String names;
    @Column(name = "personType")
    @Enumerated(EnumType.STRING)
    private TitleType personType;
    @Column(name = "userName")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @OneToMany
    private Set<Activity> activities = new HashSet<>();

    public UserRegistration() {
    }



    public UserRegistration(String names, TitleType personType, String userName, String email, String password) {
        this.names = names;
        this.personType = personType;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
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
}
