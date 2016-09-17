package com.doesuanota.api.domain.participate;

import com.doesuanota.api.endpoint.participate.ParticipantResource;
import com.doesuanota.api.infrastructure.repository.participant.Participant;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ParticipantFactoryTest {

    @Test
    public void should_convert_from_resource_to_domain(){
        ParticipantResource resource = new ParticipantResource();
        resource.setEmail("a@a.com");

        ParticipantFactory factory = new ParticipantFactory();
        final Participant result = factory.convert(resource);


        assertNotNull(result);
        assertEquals("a@a.com", result.email().toString());
    }

}