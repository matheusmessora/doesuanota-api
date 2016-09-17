package com.doesuanota.api.domain.email;

import org.junit.Assert;
import org.junit.Test;

public class EmailTest {

    @Test
    public void should_instantiate_email_from_correct_string_value(){
        final Email email = Email.valueOf("a@a.com");

        Assert.assertEquals("a@a.com", email.toString());
    }

}