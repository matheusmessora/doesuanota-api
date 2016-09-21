package com.doesuanota.api.domain.participant.service;

import com.doesuanota.api.domain.participant.Participant;

import java.util.Optional;

public interface ParticipantService {

    Participant register(Participant participant);

    Optional<Participant> findBySurveyToken(String feedbackToken);

    Participant persist(Participant participant);
}
