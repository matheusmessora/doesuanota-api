package com.doesuanota.api.domain.survey;

import com.doesuanota.api.domain.survey.exception.SurveyAlreadyAnswered;
import com.doesuanota.api.domain.survey.exception.SurveyAnsweredIncompletely;
import com.google.common.collect.Lists;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.ArrayList;
import java.util.List;

public class Survey {

    @Indexed
    private String token;

    private List<Question> questionList;
    private int answeredQuestions;

    public Survey() {
    }

    public Survey(String token) {
        this.token = token;
        answeredQuestions = 0;
        this.questionList = new ArrayList<>();
        this.questionList.add(new Question("O que achou de nosso site?"));
        this.questionList.add(new Question("Qual a probabilidade de você recomendar nossos serviços a alguém?"));
    }

    public List<Question> questions() {
        return Lists.newArrayList(questionList);
    }

    public void answer(final List<Answer> answers){
        answers.forEach(this::answer);

        final boolean notFullyAnswered = !isAnswered();
        if(notFullyAnswered){
            throw new SurveyAnsweredIncompletely();
        }
    }

    private Survey answer(final Answer answer) {
        if(isAnswered()){
            throw new SurveyAlreadyAnswered();
        }
        questionList.get(answeredQuestions).setAnswer(answer);
        answeredQuestions++;
        if(isAnswered()){
            token = null;
        }
        return this;
    }

    public boolean isAnswered() {
        return questionList.size() == answeredQuestions;
    }

    public String getToken() {
        return token;
    }
}
