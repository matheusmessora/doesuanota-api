package com.doesuanota.api.domain.email;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Value Object for Email
 */
public final class Email {

    private final String email;

    /**
     * Simple regex for email validation.
     * This must be changed in the future.
     *
     * http://stackoverflow.com/questions/8204680/java-regex-email/13013056#13013056
     */
    private static final Pattern SIMPLE_VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private static boolean validate(String emailStr) {
        Matcher matcher = SIMPLE_VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    private Email(final String email){
        this.email = email;
    }

    public static Email valueOf(String email) {
        check(email);
        return new Email(email);
    }

    private static void check(final String email) {
        final boolean emptyEmail = StringUtils.isEmpty(email);
        if(emptyEmail) {
            throw new InvalidEmail();
        }

        final boolean validEmail = validate(email);
        if(!validEmail){
            throw new InvalidEmail();
        }
    }

    public String toString() {
        return email;
    }
}
