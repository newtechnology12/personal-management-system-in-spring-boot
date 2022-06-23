//package com.manager.information.implement;
//
//import java.util.Collection;
//import java.util.Optional;
//
//import com.manager.information.domain.User;
//import com.manager.information.repository.UserRepository;
//import com.manager.information.service.UserServices;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//;
//
//@Service("userService")
//public class UserServiceImpl implements UserServices {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public Optional findUserByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    @Override
//    public Optional findUserByResetToken(String resetToken) {
//        return userRepository.findByResetToken(resetToken);
//    }
//
//
//    @Override
//    public void save(User user) {
//        userRepository.save(user);
//    }
//}