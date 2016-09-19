package com.doesuanota.api.infrastructure.repository.participant;

import com.doesuanota.api.domain.email.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Participant {

    @Id
    private String id;

    @Indexed
    private String email;

    public Participant(final Email email) {
        this.email = email.toString();
    }

    public Email email(){
        return Email.valueOf(email);
    }

    public String id() {
        return id;
    }
}
