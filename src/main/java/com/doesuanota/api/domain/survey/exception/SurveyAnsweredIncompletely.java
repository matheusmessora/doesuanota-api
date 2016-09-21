package com.doesuanota.api.domain.survey.exception;

import com.doesuanota.api.infrastructure.json.BadRequestException;

public class SurveyAnsweredIncompletely extends BadRequestException {

    public SurveyAnsweredIncompletely() {
        super("Survey was answered incompletely");
    }
}
