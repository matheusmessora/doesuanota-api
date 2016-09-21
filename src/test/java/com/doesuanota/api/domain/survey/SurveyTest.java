package com.doesuanota.api.domain.survey;

import com.doesuanota.api.domain.survey.exception.SurveyAlreadyAnswered;
import com.doesuanota.api.domain.survey.exception.SurveyAnsweredIncompletely;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.List;

public class SurveyTest {

    @Test
    public void should_return_true_if_correctly_answered(){
        final Survey survey = new Survey("token");
        List<Answer> answers = Lists.newArrayList(new Answer("yes"), new Answer("no"));
        survey.answer(answers);

        Assert.assertTrue(survey.isAnswered());
    }

    @Test
    public void should_clean_token_when_correctly_answered(){
        final Survey survey = new Survey("token");
        List<Answer> answers = Lists.newArrayList(new Answer("yes"), new Answer("no"));
        survey.answer(answers);

        Assert.assertTrue(StringUtils.isEmpty(survey.getToken()));
    }

    @Test(expected = SurveyAnsweredIncompletely.class)
    public void should_return_false_if_missing_answers(){
        final Survey survey = new Survey("token");
        List<Answer> answers = Lists.newArrayList(new Answer("yes"));
        survey.answer(answers);
    }

    @Test(expected = SurveyAlreadyAnswered.class)
    public void should_throw_error_when_survey_already_answered(){
        final Survey survey = new Survey("token");

        List<Answer> answers = Lists.newArrayList(new Answer("yes"), new Answer("no"), new Answer("bad answer"));
        survey.answer(answers);
    }


}