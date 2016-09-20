package com.doesuanota.api.domain.participant.service;

import com.doesuanota.api.domain.email.Email;
import com.doesuanota.api.domain.participant.Participant;
import com.doesuanota.api.infrastructure.repository.participant.ParticipantRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.util.Assert;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ParticipantServiceImplTest {

    @Mock
    private ParticipantRepository repository;

    @Mock
    private WelcomeEmailService emailService;

    @InjectMocks
    private ParticipantServiceImpl service;

    @Test
    public void should_persist_participant_when_register(){
        final Email email = Email.valueOf("a@a.com");
        final Participant mockParticipant = new Participant(email);
        when(repository.save(any(Participant.class))).thenReturn(mockParticipant);

        Participant participant = new Participant(email);
        service.register(participant);

        ArgumentCaptor<Participant> participantArgument = ArgumentCaptor.forClass(Participant.class);

        verify(repository, times(1)).save(participantArgument.capture());
        verify(emailService, times(1)).sendWelcomeEmail(any(Participant.class));

        final Participant value = participantArgument.getValue();
        Assert.notNull(value.questionToken());
    }

}