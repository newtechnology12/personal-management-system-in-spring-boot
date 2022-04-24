package com.manager.information.domain;

import com.manager.information.validator.PasswordConfirmation;

import javax.validation.constraints.NotEmpty;

@PasswordConfirmation(
        password = "password",
        confirmPassword = "confirmPassword",
        message = "PASSWORD_NOT_EQUAL"
)
public class ResetPassword {
    @NotEmpty
    private String password;
    @NotEmpty
    private String confirmationPassword;
    @NotEmpty
    private String token;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmationPassword() {
        return confirmationPassword;
    }

    public void setConfirmationPassword(String confirmationPassword) {
        this.confirmationPassword = confirmationPassword;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
