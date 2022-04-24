package com.manager.information.service;

import com.manager.information.domain.UserRegistration;

import javax.swing.text.html.Option;
import java.util.List;


public interface IUserRegistrationService {
    UserRegistration createUserRegistration(UserRegistration userRegistration);
    List<UserRegistration> findAllUserRegistration();
    UserRegistration getUserById(Long userId);
    UserRegistration getUserByEmail(String email);
    UserRegistration getUserByUserName(String username);
    UserRegistration updateUser(UserRegistration userRegistration);

    void removeUserRegistration(Long id);
}
