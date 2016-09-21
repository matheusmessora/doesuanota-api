package com.doesuanota.api.domain.survey.exception;

import com.doesuanota.api.infrastructure.json.BadRequestException;

public class EmptyAnswer extends BadRequestException {

    public EmptyAnswer() {
        super("Answer is empty");
    }
}
