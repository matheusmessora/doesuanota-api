package com.doesuanota.api.infrastructure.repository.participant;

import com.doesuanota.api.domain.email.Email;
import com.doesuanota.api.domain.participant.Participant;
import org.junit.Assert;
import org.junit.Test;

public class ParticipantTest {

    @Test
    public void should_generate_token_with_UUID_standard(){
        Participant participant = new Participant(Email.valueOf("a@a.com"));

        Assert.assertNull(participant.questionToken());
        participant.generateQuestionToken();
        Assert.assertNotNull(participant.questionToken());
    }

    @Test(expected = TokenAlreadyGenerated.class)
    public void should_throw_error_when_token_is_already_present(){
        Participant participant = new Participant(Email.valueOf("a@a.com"));

        participant.generateQuestionToken();
        participant.generateQuestionToken();
    }

}