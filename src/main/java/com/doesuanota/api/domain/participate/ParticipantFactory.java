package com.doesuanota.api.domain.participate;

import com.doesuanota.api.domain.email.Email;
import com.doesuanota.api.endpoint.participate.ParticipantResource;
import com.doesuanota.api.infrastructure.repository.participant.Participant;
import org.springframework.stereotype.Service;

@Service
public class ParticipantFactory {

    public Participant convert(ParticipantResource resource){
        final Email email = Email.valueOf(resource.getEmail());
        return new Participant(email);
    }

}
