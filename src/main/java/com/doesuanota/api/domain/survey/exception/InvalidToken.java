package com.doesuanota.api.domain.survey.exception;

import com.doesuanota.api.infrastructure.json.BadRequestException;

public class InvalidToken extends BadRequestException {

    public InvalidToken() {
        super("Invalid token");
    }
}
