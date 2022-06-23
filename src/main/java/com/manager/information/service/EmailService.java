package com.manager.information.service;

import com.manager.information.domain.Email;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    void sendEmail(Email email);
    public void sendEmail(SimpleMailMessage email);

}
