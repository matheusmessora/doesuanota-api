package com.doesuanota.api.domain.survey;

public class Question {

    private String question;
    private String answer;

    public Question(final String question) {
        this.question = question;
    }

    public void setAnswer(final Answer answer) {
        this.answer = answer.value();
    }

    public String getQuestion() {
        return question;
    }
}
