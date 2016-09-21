package integration;

import com.doesuanota.api.endpoint.participant.ParticipantResource;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.doesuanota.api.helper.ParticipantHelper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.net.URL;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SurveyEndpointTest extends BaseIntegrationTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParticipantHelper participantHelper;

    @Test
    public void should_return_survey_with_correct_id() throws Exception {
        ParticipantResource resource = participantHelper.createParticipant(mockMvc);

        String surveyId = resource.getSurveyToken();

        mockMvc.perform(get("/surveys/" + surveyId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists())
                .andExpect(jsonPath("$.answered").value(false))
                .andExpect(jsonPath("$.questions[0].question").exists())
                .andExpect(jsonPath("$.questions[1].question").exists())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void should_return_created_when_survey_is_answered() throws Exception {
        ParticipantResource resource = participantHelper.createParticipant(mockMvc);
        String surveyId = resource.getSurveyToken();

        final URL file = Resources.getResource("requests/survey/success_create.json");
        String request = Resources.toString(file, Charsets.UTF_8);

        mockMvc.perform(post("/surveys/" + surveyId + "/answers")
                .content(request)
                .contentType(contentType))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.token").doesNotExist())
                .andExpect(jsonPath("$.answered").value(true))
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void should_thrown_bad_request_when_invalid_id() throws Exception {
        String surveyId = "a";

        mockMvc.perform(get("/surveys/" + surveyId))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Invalid token"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void should_thrown_bad_request_when_incomplete_answers() throws Exception {
        ParticipantResource resource = participantHelper.createParticipant(mockMvc);
        String surveyId = resource.getSurveyToken();

        final URL file = Resources.getResource("requests/survey/incomplete_answers.json");
        String request = Resources.toString(file, Charsets.UTF_8);

        mockMvc.perform(post("/surveys/" + surveyId + "/answers")
                .content(request)
                .contentType(contentType))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Survey was answered incompletely"))
                .andDo(MockMvcResultHandlers.print());
    }

}
