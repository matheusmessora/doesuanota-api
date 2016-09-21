package com.doesuanota.api.helper;

import com.doesuanota.api.endpoint.participant.ParticipantResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URL;
import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@Component
public class ParticipantHelper {

    MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Autowired
    private ObjectMapper mapper;

    public ParticipantResource createParticipant(MockMvc mockMvc) throws Exception {
        final URL file = Resources.getResource("requests/participate/success_create.json");
        String request = Resources.toString(file, Charsets.UTF_8);

        final String createdParticipant = mockMvc.perform(post("/participants")
                .content(request)
                .contentType(contentType))
                .andReturn().getResponse().getContentAsString();

        return mapper.readValue(createdParticipant, ParticipantResource.class);
    }
}
