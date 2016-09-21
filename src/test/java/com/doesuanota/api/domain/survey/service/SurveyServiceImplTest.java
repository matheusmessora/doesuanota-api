package com.doesuanota.api.domain.survey.service;

import com.doesuanota.api.domain.email.Email;
import com.doesuanota.api.domain.participant.Participant;
import com.doesuanota.api.domain.participant.service.ParticipantService;
import com.doesuanota.api.domain.survey.Survey;
import com.doesuanota.api.domain.survey.exception.SurveyNotFound;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SurveyServiceImplTest {

    @Mock
    private ParticipantService participantService;

    @InjectMocks
    private SurveyServiceImpl service;


    @Test
    public void should_return_survey_when_participant_found_by_token(){
        final Participant participant = new Participant(Email.valueOf("a@a.com"));
        participant.generateSurvey();
        when(participantService.findBySurveyToken(anyString()))
                .thenReturn(Optional.of(participant));


        Survey survey = service.findByToken("fake-token");
        Assert.notNull(survey);

    }

    @Test(expected = SurveyNotFound.class)
    public void should_throw_error_when_participant_not_found_by_token(){
        when(participantService.findBySurveyToken(anyString()))
                .thenReturn(Optional.empty());

        service.findByToken("invalid-token");
    }
}
