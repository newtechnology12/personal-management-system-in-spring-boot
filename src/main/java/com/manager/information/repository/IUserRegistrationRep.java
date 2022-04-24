package com.manager.information.repository;

import com.manager.information.domain.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IUserRegistrationRep extends JpaRepository<UserRegistration,Long> {

    UserRegistration findByEmail(String email);
    UserRegistration findByUserName(String userName);
}
