package com.doesuanota.api.endpoint.participant;

import org.junit.Assert;
import org.junit.Test;

public class ParticipantResourceTest {


    @Test
    public void should_mask_email(){
        ParticipantResource resource = new ParticipantResource();

        resource.setEmail("1234567890@gmail.com");
        resource.maskEmail();

        Assert.assertEquals("12********@gmail.com", resource.getEmail());
    }
}