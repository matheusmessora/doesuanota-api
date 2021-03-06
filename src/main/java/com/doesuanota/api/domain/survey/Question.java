package com.doesuanota.api.domain.survey;

import org.springframework.util.StringUtils;

public class Question {

    private String question;
    private String answer;

    public Question(final String question) {
        this.question = question;
    }

    public void setAnswer(final Answer answer) {
        this.answer = answer.value();
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    public boolean isAnswered() {
        return !StringUtils.isEmpty(answer);
    }
}
