package com.doesuanota.api.domain.email;

/**
 * Value Object for Email
 */
public final class Email {

    private final String email;

    private Email(final String email){
        this.email = email;
    }

    public static Email valueOf(String email) {
        return new Email(email);
    }

    public String toString() {
        return email;
    }
}
