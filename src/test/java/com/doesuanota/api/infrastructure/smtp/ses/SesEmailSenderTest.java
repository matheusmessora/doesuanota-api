package com.doesuanota.api.infrastructure.smtp.ses;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.doesuanota.api.domain.email.Email;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SesEmailSenderTest {

    @Mock
    private AmazonSimpleEmailServiceClient client;

    @InjectMocks
    private SesEmailSender sender;


    @Test
    public void should_call_aws_sdk_to_send_email() throws Exception {
        sender.sendEmail(Email.valueOf("a@a.com"), "expected-body");

        Mockito.verify(client, Mockito.times(1)).setRegion(Mockito.any());
        Mockito.verify(client, Mockito.times(1)).setIdentityDkimEnabled(Mockito.any());

        ArgumentCaptor<SendEmailRequest> sendEmailRequestArgument = ArgumentCaptor.forClass(SendEmailRequest.class);
        Mockito.verify(client, Mockito.times(1)).sendEmail(sendEmailRequestArgument.capture());
        final SendEmailRequest value = sendEmailRequestArgument.getValue();

        assertEquals("expected-body", value.getMessage().getBody().getHtml().getData());
        assertEquals("a@a.com", value.getDestination().getToAddresses().get(0));
        assertEquals("Doe sua nota <contato@doesuanota.com.br>", value.getSource());
        assertEquals("Doe sua nota", value.getMessage().getSubject().getData());
    }

}