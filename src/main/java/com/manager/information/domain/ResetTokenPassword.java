package com.manager.information.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

public class ResetTokenPassword {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    @Column(nullable = false, unique = true)
    private String token;
    @OneToOne(targetEntity = UserRegistration.class,fetch = FetchType.EAGER)
    private UserRegistration userRegistration;
    @Column(nullable = false)
    private LocalDateTime expirationDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserRegistration getUserRegistration() {
        return userRegistration;
    }

    public void setUserRegistration(UserRegistration userRegistration) {
        this.userRegistration = userRegistration;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }
}
