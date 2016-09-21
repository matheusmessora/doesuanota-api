package com.doesuanota.api.domain.participant;

import com.doesuanota.api.domain.email.Email;
import com.doesuanota.api.endpoint.participant.ParticipantResource;
import org.springframework.stereotype.Service;

@Service
public class ParticipantFactory {

    public Participant convert(ParticipantResource resource){
        final Email email = Email.valueOf(resource.getEmail());
        return new Participant(email);
    }

}
