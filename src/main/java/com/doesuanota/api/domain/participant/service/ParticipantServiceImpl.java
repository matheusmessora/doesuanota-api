package com.doesuanota.api.domain.participant.service;

import com.doesuanota.api.domain.email.Email;
import com.doesuanota.api.domain.participant.Participant;
import com.doesuanota.api.domain.participant.exception.ParticipantAlreadyRegistered;
import com.doesuanota.api.infrastructure.repository.participant.ParticipantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParticipantRepository repository;

    @Autowired
    private WelcomeEmailService welcomeEmailService;

    public Participant register(final Participant participant) {
        logger.info("Registering email=" + participant.email());
        checkIfExists(participant.email());

        participant.generateSurvey();

        final Participant savedParticipant = repository.save(participant);

        sendWelcomeEmail(savedParticipant);

        logger.info("Registered email=" + participant.email());

        return savedParticipant;
    }

    private void checkIfExists(final Email email) {
        final Participant participant = repository.findByEmail(email.toString());
        if(participant != null){
            logger.info("Already registered email=" + participant.email());
            throw new ParticipantAlreadyRegistered(email);
        }
    }

    public Optional<Participant> findBySurveyToken(final String surveyToken) {
        return Optional.ofNullable(repository.findBySurveyToken(surveyToken));
    }

    public Participant persist(final Participant participant) {
        return repository.save(participant);
    }

    public List<Participant> findAll() {
        return repository.findAll();
    }

    private void sendWelcomeEmail(final Participant savedParticipant) {
        welcomeEmailService.sendWelcomeEmail(savedParticipant);
    }
}
