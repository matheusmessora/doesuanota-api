package com.doesuanota.api.domain.email;

import org.junit.Assert;
import org.junit.Test;

public class EmailTest {

    @Test
    public void should_instantiate_email_from_correct_string_value(){
        final Email email = Email.valueOf("a@a.co");

        Assert.assertEquals("a@a.co", email.toString());
    }

    @Test(expected = InvalidEmail.class)
    public void should_throw_error_when_empty_email(){
        Email.valueOf("");
    }

    @Test(expected = InvalidEmail.class)
    public void should_throw_error_when_invalid_email(){
        Email.valueOf("aaa.com");
    }

}