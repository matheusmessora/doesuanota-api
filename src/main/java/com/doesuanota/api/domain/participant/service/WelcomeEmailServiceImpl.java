package com.doesuanota.api.domain.participant.service;

import com.doesuanota.api.domain.participant.Participant;
import com.doesuanota.api.infrastructure.smtp.EmailSender;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;

@Service
public class WelcomeEmailServiceImpl implements WelcomeEmailService {

    @Autowired
    private EmailSender sender;

    public void sendWelcomeEmail(final Participant participant) {
        sender.sendEmail(participant.email(), getBodyMessage(participant));
    }

    private String getBodyMessage(Participant participant){
        try {
            final URL file = Resources.getResource("welcome-email.txt");
            String body = Resources.toString(file, Charsets.UTF_8);

            return body.replace("{{token}}", participant.questionToken());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
