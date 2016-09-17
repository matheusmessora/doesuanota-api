package integration;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ParticipantEndpointTest extends BaseIntegrationTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void success_create() throws Exception {
        final URL file = Resources.getResource("requests/participate/success_create.json");
        String request = Resources.toString(file, Charsets.UTF_8);

        final String response = mockMvc.perform(post("/participant")
                .content(request)
                .contentType(contentType))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value("matheus@example.com"))
                .andExpect(jsonPath("$.id").exists())
                .andReturn().getResponse().getContentAsString();

        logger.debug(response);

    }
}
