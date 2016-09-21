package com.doesuanota.api.domain.survey;

import com.doesuanota.api.domain.survey.exception.EmptyAnswer;
import org.junit.Assert;
import org.junit.Test;

public class AnswerTest {


    @Test(expected = EmptyAnswer.class)
    public void should_throw_error_when_empty_answer(){
        new Answer("");
    }


    @Test
    public void should_get_value(){
        final Answer answer = new Answer("expected");
        Assert.assertEquals("expected", answer.value());
    }
}