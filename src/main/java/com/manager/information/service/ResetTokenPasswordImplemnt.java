//package com.manager.information.service;
//
//import com.manager.information.domain.ResetTokenPassword;
//import com.manager.information.repository.IResetTokenPasswordRep;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ResetTokenPasswordImplemnt implements ResetTockenPsswordService{
//    @Autowired
//    private IResetTokenPasswordRep iResetTokenPasswordRep;
//    @Override
//    public ResetTokenPassword findByToken(String token) {
//        return iResetTokenPasswordRep.findByToken(token);
//    }
//
//    @Override
//    public ResetTokenPassword saveToken(ResetTokenPassword resetTokenPassword) {
//        return iResetTokenPasswordRep.save(resetTokenPassword);
//    }
//}
