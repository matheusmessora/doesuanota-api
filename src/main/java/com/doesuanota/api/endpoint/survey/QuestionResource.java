package com.doesuanota.api.endpoint.survey;

import com.doesuanota.api.domain.survey.Question;

public class QuestionResource {

    private String question;
    private String answer;

    public QuestionResource(final Question question) {
        this.question = question.getQuestion();
        this.answer = question.getAnswer();
    }


    public QuestionResource() {
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(final String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(final String question) {
        this.question = question;
    }
}
