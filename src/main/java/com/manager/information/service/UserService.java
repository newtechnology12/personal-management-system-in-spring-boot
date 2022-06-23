package com.manager.information.service;

import com.manager.information.domain.User;

import java.util.Optional;

public interface UserService {
    public Optional<User> findUserByEmail(String email);
    public Optional<User> findUserByResetToken(String resetToken);
    public void save(User user);
}
