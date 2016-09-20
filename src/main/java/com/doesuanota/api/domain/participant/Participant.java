package com.doesuanota.api.domain.participant;

import com.doesuanota.api.domain.email.Email;
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

    @Indexed
    private String questionToken;

    public Participant(final Email email) {
        this.email = email.toString();
    }

    public Email email(){
        return Email.valueOf(email);
    }

    public String id() {
        return id;
    }

    public void generateQuestionToken() {
        if (questionToken != null) {
            throw new TokenAlreadyGenerated();
        }

        this.questionToken = UUID.randomUUID().toString();
    }


    public String questionToken() {
        return questionToken;
    }
}
