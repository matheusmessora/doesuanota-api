package com.doesuanota.api.domain.email;

import com.doesuanota.api.infrastructure.json.BadRequestException;

public class InvalidEmail extends BadRequestException {

    public InvalidEmail() {
        super("Invalid e-mail");
    }
}
