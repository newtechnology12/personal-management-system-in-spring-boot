package com.manager.information.service;

import com.manager.information.domain.ResetTokenPassword;

public interface ResetTockenPsswordService {
    ResetTokenPassword findByToken(String token);
    ResetTokenPassword saveToken(ResetTokenPassword resetTokenPassword);
}
