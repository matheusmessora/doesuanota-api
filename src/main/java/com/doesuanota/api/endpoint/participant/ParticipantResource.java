package com.doesuanota.api.endpoint.participant;

import com.doesuanota.api.domain.participant.Participant;
import com.doesuanota.api.endpoint.survey.SurveyResource;

public class ParticipantResource {

    private SurveyResource survey;
    private String surveyToken;
    private String id;
    private String email;

    public ParticipantResource() {}

    ParticipantResource(final Participant createdParticipant) {
        this.id = createdParticipant.id();
        this.email = createdParticipant.email().toString();
        this.surveyToken = createdParticipant.surveyToken();
        this.survey = new SurveyResource(createdParticipant.survey());
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

    public String getSurveyToken() {
        return surveyToken;
    }

    public void setSurveyToken(final String surveyToken) {
        this.surveyToken = surveyToken;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public SurveyResource getSurvey() {
        return survey;
    }

    public void setSurvey(final SurveyResource survey) {
        this.survey = survey;
    }

    /**
     * Based on http://stackoverflow.com/questions/33100298/masking-of-email-address-in-java
     */
    void maskEmail(){
        email = email.replaceAll("(^[^@]{2}|(?!^)\\G)[^@]", "$1*");
    }
}
