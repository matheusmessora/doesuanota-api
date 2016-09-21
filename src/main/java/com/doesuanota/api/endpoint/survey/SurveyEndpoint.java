package com.doesuanota.api.endpoint.survey;

import com.doesuanota.api.domain.survey.Answer;
import com.doesuanota.api.domain.survey.Survey;
import com.doesuanota.api.domain.survey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("surveys")
public class SurveyEndpoint {

    @Autowired
    private SurveyService service;

    @RequestMapping(value ="/{token}", method = GET, produces = {APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<SurveyResource> get(@PathVariable("token") String token) {

        final Survey survey = service.findByToken(token);

        return new ResponseEntity<>(new SurveyResource(survey), HttpStatus.OK);
    }

    @RequestMapping(value ="/{token}/answers", method = POST, produces = {APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<SurveyResource> answer(@PathVariable("token") String token,
                                                 @RequestBody List<AnswerResource> answersResource) {

        List<Answer> answers = answersResource
                .stream()
                .map(AnswerResource::getAnswer)
                .map(Answer::new)
                .collect(Collectors.toList());
        final Survey survey = service.answer(token, answers);

        return new ResponseEntity<>(new SurveyResource(survey), HttpStatus.CREATED);
    }
}
