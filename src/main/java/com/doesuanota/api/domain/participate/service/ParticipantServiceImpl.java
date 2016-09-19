package com.doesuanota.api.domain.participate.service;

import com.doesuanota.api.domain.email.Email;
import com.doesuanota.api.infrastructure.repository.participant.Participant;
import com.doesuanota.api.infrastructure.repository.participant.ParticipantRepository;
import com.doesuanota.api.infrastructure.smtp.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository repository;
    private final EmailSender emailSender;

    @Autowired
    public ParticipantServiceImpl(final ParticipantRepository repository, final EmailSender emailSender) {
        this.repository = repository;
        this.emailSender = emailSender;
    }

    public Participant register(final Participant participant) {
        final Participant savedParticipant = repository.save(participant);

        sendAutoResponse(savedParticipant);

        return savedParticipant;
    }

    private void sendAutoResponse(final Participant savedParticipant) {
        final Email to = savedParticipant.email();
        emailSender.sendEmail(to, "Thank you!");
    }
}
