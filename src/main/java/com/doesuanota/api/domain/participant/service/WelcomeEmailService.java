package com.doesuanota.api.domain.participant.service;

import com.doesuanota.api.domain.participant.Participant;

public interface WelcomeEmailService {

    void sendWelcomeEmail(Participant participant);
}
