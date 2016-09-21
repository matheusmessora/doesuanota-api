package com.doesuanota.api.endpoint;


import com.doesuanota.api.infrastructure.json.BadRequestException;

public class ApiError {

    private String error;

    public ApiError(final String error) {
        this.error = error;
    }

    public ApiError(final BadRequestException exc) {
        this.error = exc.getError();
    }

    public String getError() {
        return error;
    }
}
