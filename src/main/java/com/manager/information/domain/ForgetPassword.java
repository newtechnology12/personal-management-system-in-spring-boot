package com.manager.information.domain;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class ForgetPassword {
    @NotNull(message = "{MAIL_REQUIRED}")
    @Email(message = "{NOT_VALID-EMAIL}")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
