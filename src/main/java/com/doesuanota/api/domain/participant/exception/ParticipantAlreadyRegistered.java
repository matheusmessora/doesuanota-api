package com.doesuanota.api.domain.participant.exception;

import com.doesuanota.api.domain.email.Email;
import com.doesuanota.api.infrastructure.json.BadRequestException;

public class ParticipantAlreadyRegistered extends BadRequestException {

    public ParticipantAlreadyRegistered(Email email) {
        super("Participant " + email.toString() + " already registered");
    }
}
