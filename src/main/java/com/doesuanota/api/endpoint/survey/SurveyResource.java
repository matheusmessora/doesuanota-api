package com.doesuanota.api.endpoint.survey;

import com.doesuanota.api.domain.survey.Survey;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SurveyResource {

    private String token;
    private boolean answered;
    private List<QuestionResource> questions;

    public SurveyResource(final Survey survey) {
        this.token = survey.getToken();
        this.answered = survey.isAnswered();
        this.questions = new ArrayList<>();
        questions.addAll(survey.questions().stream().map(QuestionResource::new).collect(Collectors.toList()));
    }

    public SurveyResource() {
    }

    public List<QuestionResource> getQuestions() {
        return questions;
    }

    public void setQuestions(final List<QuestionResource> questions) {
        this.questions = questions;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(final boolean answered) {
        this.answered = answered;
    }

    public String getToken() {
        return token;
    }

    public void setToken(final String token) {
        this.token = token;
    }
}
