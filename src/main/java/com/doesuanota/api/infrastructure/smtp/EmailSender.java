package com.doesuanota.api.infrastructure.smtp;

import com.doesuanota.api.domain.email.Email;

public interface EmailSender {

    void sendEmail(Email to, String message);
}
