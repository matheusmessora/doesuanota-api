package com.doesuanota.api.domain.participant;

import com.doesuanota.api.domain.email.Email;
import com.doesuanota.api.domain.survey.Survey;
import com.doesuanota.api.infrastructure.repository.participant.TokenAlreadyGenerated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class Participant {

    @Id
    private String id;

    @Indexed
    private String email;

    private Survey survey;

    /**
     * for spring-data only
     */
    public Participant() {
    }

    public Participant(final Email email) {
        this.email = email.toString();
    }

    public Email email(){
        return Email.valueOf(email);
    }

    public String id() {
        return id;
    }

    public void generateSurvey() {
        if (survey != null && survey.getToken() != null) {
            throw new TokenAlreadyGenerated();
        }

        final String token = UUID.randomUUID().toString();
        this.survey = new Survey(token);
    }

    public Survey survey() {
        return survey;
    }

    public String surveyToken() {
        if (survey() == null) {
            return null;
        }
        return survey().getToken();
    }
}
