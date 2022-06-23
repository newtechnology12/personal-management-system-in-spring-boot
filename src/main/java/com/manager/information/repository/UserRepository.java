package com.manager.information.repository;

import com.manager.information.domain.Role;
import com.manager.information.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
//    @Query(value = "Select * From User Where reset_token = ?1", nativeQuery = true)
    User findByResetToken(String resetToken);
    @Query("select u from User u where u.email = ?1" )
    User findByEmail(String email);
    //Custom query
    @Query(value = "select * from user s where s.first_name like %:keyword% or s.personType like %:keyword%", nativeQuery = true)
    List<User> findByKeyword(@Param("keyword") String keyword);
    User findByUserName(String userName);

    @Query("SELECT user FROM User user LEFT JOIN user.roles role WHERE role.id = ?1")
    List<User> findUserByRole(Role role);




}
