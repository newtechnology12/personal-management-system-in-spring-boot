package com.manager.information.service;


import com.manager.information.domain.UserRegistration;
import com.manager.information.repository.IUserRegistrationRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserRegistrationService implements IUserRegistrationService {
    @Autowired
    private IUserRegistrationRep userRegistrationRep;

    @Override
    public UserRegistration createUserRegistration(UserRegistration userRegistration) {
        try {
            return userRegistrationRep.save(userRegistration);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserRegistration> findAllUserRegistration() {
        return userRegistrationRep.findAll();
    }

    @Override
    public UserRegistration getUserById(Long userId) {
        return userRegistrationRep.getById(userId);
    }

    @Override
    public UserRegistration getUserByEmail(String email) {
        return userRegistrationRep.findByEmail(email);
    }

    @Override
    public UserRegistration getUserByUserName(String username) {
        return userRegistrationRep.findByUserName(username);
    }

    @Override
    public UserRegistration updateUser(UserRegistration userRegistration) {
        try {
            return userRegistrationRep.save(userRegistration);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void removeUserRegistration(Long id) {
        try {
            userRegistrationRep.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
