package com.doesuanota.api.infrastructure.smtp.ses;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.*;
import com.doesuanota.api.domain.email.Email;
import com.doesuanota.api.infrastructure.smtp.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesEmailSender implements EmailSender {

    @Autowired
    private AmazonSimpleEmailServiceClient client;

    /**
     * Based on
     * https://github.com/matheusmessora/muonline-api2/blob/master/src/main/java/pandox/china/service/EmailService.java
     *
     * @param to
     * @param message
     */
    public void sendEmail(final Email to, final String message) {
        // Construct an object to contain the recipient address.
        Destination destination = new Destination().withToAddresses(to.toString());

        // Create the subject and body of the message.
        Content subject = new Content().withData("Doe sua nota");
        Content textBody = new Content().withData(message);
        Body body = new Body().withHtml(textBody);

        // Create a message with the specified subject and body.
        Message emailMessage = new Message(subject, body);

        // Assemble the email.
        SendEmailRequest request = new SendEmailRequest()
                .withSource("Doe sua nota <contato@doesuanota.com.br>")
                .withDestination(destination)
                .withMessage(emailMessage);


        Region REGION = Region.getRegion(Regions.US_EAST_1);
        client.setRegion(REGION);

        SetIdentityDkimEnabledRequest dkimEnabledRequest = new SetIdentityDkimEnabledRequest();
        dkimEnabledRequest.setIdentity("doesuanota.com.br");
        dkimEnabledRequest.setDkimEnabled(true);
        client.setIdentityDkimEnabled(dkimEnabledRequest);

        // Send the email.
        client.sendEmail(request);
    }
}
