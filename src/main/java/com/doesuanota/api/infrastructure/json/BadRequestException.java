package com.doesuanota.api.infrastructure.json;


public class BadRequestException extends RuntimeException {

    private String error;

    public BadRequestException(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
