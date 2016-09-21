package integration;

import com.doesuanota.api.helper.ParticipantHelper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.net.URL;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ParticipantEndpointTest extends BaseIntegrationTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParticipantHelper helper;

    @Test
    public void success_create() throws Exception {
        final URL file = Resources.getResource("requests/participate/success_create.json");
        String request = Resources.toString(file, Charsets.UTF_8);

        mockMvc.perform(post("/participants")
                .content(request)
                .contentType(contentType))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value("success@simulator.amazonses.com"))
                .andExpect(jsonPath("$.surveyToken").exists())
                .andExpect(jsonPath("$.id").exists())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void should_return_badrequest_when_empty_email() throws Exception {
        final URL file = Resources.getResource("requests/participate/empty_email.json");
        String request = Resources.toString(file, Charsets.UTF_8);

        mockMvc.perform(post("/participants")
                .content(request)
                .contentType(contentType))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Invalid e-mail"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void should_return_badrequest_when_email_already_registered() throws Exception {
        helper.createParticipant(mockMvc);

        final URL file = Resources.getResource("requests/participate/success_create.json");
        String request = Resources.toString(file, Charsets.UTF_8);

        mockMvc.perform(post("/participants")
                .content(request)
                .contentType(contentType))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Participant success@simulator.amazonses.com already registered"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void should_return_badrequest_when_invalid_email() throws Exception {
        final URL file = Resources.getResource("requests/participate/invalid_email.json");
        String request = Resources.toString(file, Charsets.UTF_8);

        mockMvc.perform(post("/participants")
                .content(request)
                .contentType(contentType))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Invalid e-mail"))
                .andDo(MockMvcResultHandlers.print());

    }
}
