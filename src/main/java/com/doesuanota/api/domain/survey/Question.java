package com.doesuanota.api.domain.survey;

public class Question {

    private String question;
    private Answer answer;

    public Question(final String question) {
        this.question = question;
    }

    public void setAnswer(final Answer answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }
}
