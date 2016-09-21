package com.doesuanota.api.domain.survey;

import com.doesuanota.api.domain.survey.exception.EmptyAnswer;
import org.springframework.util.StringUtils;

/**
 * Value Object
 */
public class Answer {

    private String answer;

    public Answer(final String answer) {
        if(StringUtils.isEmpty(answer)){
            throw new EmptyAnswer();
        }
        this.answer = answer;
    }

    public String value() {
        return answer;
    }
}
