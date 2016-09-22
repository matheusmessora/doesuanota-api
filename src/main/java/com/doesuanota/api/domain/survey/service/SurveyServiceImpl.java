package com.doesuanota.api.domain.survey.service;

import com.doesuanota.api.domain.participant.Participant;
import com.doesuanota.api.domain.participant.service.ParticipantService;
import com.doesuanota.api.domain.survey.Answer;
import com.doesuanota.api.domain.survey.Survey;
import com.doesuanota.api.domain.survey.exception.InvalidToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private ParticipantService participantService;

    public Survey findByToken(final String token) {
        final Participant participant = getParticipant(token);
        return participant.survey();
    }

    public Survey answer(final String token, final List<Answer> answers) {
        final Participant participant = getParticipant(token);

        final Survey survey = participant.survey();
        survey.answer(answers);

        participantService.persist(participant);

        return survey;
    }

    private Participant getParticipant(final String token) {
        final Optional<Participant> participantOptional = participantService.findBySurveyToken(token);
        return participantOptional.orElseThrow(InvalidToken::new);
    }
}
