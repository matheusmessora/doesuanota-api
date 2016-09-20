package com.doesuanota.api.endpoint.participate;

import com.doesuanota.api.domain.participant.Participant;

public class ParticipantResource {

    private String questionToken;
    private String id;
    private String email;

    public ParticipantResource() {}

    ParticipantResource(final Participant createdParticipant) {
        this.id = createdParticipant.id();
        this.email = createdParticipant.email().toString();
        this.questionToken = createdParticipant.questionToken();
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

    public String getQuestionToken() {
        return questionToken;
    }

    public void setQuestionToken(final String questionToken) {
        this.questionToken = questionToken;
    }

    public void setEmail(final String email) {

        this.email = email;
    }
}
