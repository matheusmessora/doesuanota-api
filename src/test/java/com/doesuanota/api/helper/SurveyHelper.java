package com.doesuanota.api.helper;

import com.doesuanota.api.endpoint.participant.ParticipantResource;
import com.doesuanota.api.endpoint.survey.SurveyResource;
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
public class SurveyHelper {

    MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Autowired
    private ObjectMapper mapper;

    public SurveyResource answerSurvey(ParticipantResource resource, MockMvc mockMvc) throws Exception {
        final URL file = Resources.getResource("requests/survey/success_create.json");
        String request = Resources.toString(file, Charsets.UTF_8);

        final String createdParticipant = mockMvc.perform(post("/surveys/" + resource.getSurveyToken() + "/answers")
                .content(request)
                .contentType(contentType))
                .andReturn().getResponse().getContentAsString();

        return mapper.readValue(createdParticipant, SurveyResource.class);
    }
}
