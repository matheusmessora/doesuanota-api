package com.doesuanota.api.domain.survey.exception;

import com.doesuanota.api.infrastructure.json.BadRequestException;

public class SurveyAlreadyAnswered extends BadRequestException {

    public SurveyAlreadyAnswered() {
        super("Survey is already answered");
    }
}
