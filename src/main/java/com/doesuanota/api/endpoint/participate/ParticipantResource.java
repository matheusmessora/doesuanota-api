package com.doesuanota.api.endpoint.participate;

import com.doesuanota.api.infrastructure.repository.participant.Participant;

public class ParticipantResource {

    private String id;
    private String email;

    public ParticipantResource() {}

    ParticipantResource(final Participant createdParticipant) {
        this.id = createdParticipant.id();
        this.email = createdParticipant.email().toString();
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
}
