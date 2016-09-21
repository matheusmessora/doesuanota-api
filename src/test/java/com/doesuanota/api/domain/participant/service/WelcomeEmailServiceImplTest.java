package com.doesuanota.api.domain.participant.service;

import com.doesuanota.api.domain.email.Email;
import com.doesuanota.api.domain.participant.Participant;
import com.doesuanota.api.infrastructure.smtp.EmailSender;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.net.URL;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class WelcomeEmailServiceImplTest {

    @Mock
    private EmailSender emailSender;

    @InjectMocks
    private WelcomeEmailServiceImpl service;

    @Test
    public void sendWelcomeEmail() throws Exception {
        Participant participant = new Participant(Email.valueOf("a@a.com"));
        participant.generateSurvey();

        final String token = participant.surveyToken();
        String expectedBody = getExpectedBody(token);

        service.sendWelcomeEmail(participant);

        ArgumentCaptor<String> bodyArgument = ArgumentCaptor.forClass(String.class);

        Mockito.verify(emailSender, times(1)).sendEmail(any(Email.class), bodyArgument.capture());

        final String bodyValue = bodyArgument.getValue();

        Assert.assertEquals(bodyValue, expectedBody);

    }

    private String getExpectedBody(String token) throws IOException {
        final URL file = Resources.getResource("welcome-email.txt");
        String body = Resources.toString(file, Charsets.UTF_8);

        return body.replace("{{token}}", token);
    }


}