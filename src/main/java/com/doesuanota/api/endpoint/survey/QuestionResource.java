package com.doesuanota.api.endpoint.survey;

public class QuestionResource {

    private String question;

    public QuestionResource(final String question) {
        this.question = question;
    }


    public QuestionResource() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(final String question) {
        this.question = question;
    }
}
