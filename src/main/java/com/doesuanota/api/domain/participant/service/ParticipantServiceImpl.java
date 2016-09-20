package com.doesuanota.api.domain.participant.service;

import com.doesuanota.api.domain.participant.Participant;
import com.doesuanota.api.infrastructure.repository.participant.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    @Autowired
    private ParticipantRepository repository;

    @Autowired
    private WelcomeEmailService welcomeEmailService;

    public Participant register(final Participant participant) {
        participant.generateQuestionToken();

        final Participant savedParticipant = repository.save(participant);

        sendWelcomeEmail(savedParticipant);

        return savedParticipant;
    }

    private void sendWelcomeEmail(final Participant savedParticipant) {
        welcomeEmailService.sendWelcomeEmail(savedParticipant);
    }
}
