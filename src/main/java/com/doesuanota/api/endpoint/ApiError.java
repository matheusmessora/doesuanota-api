package com.doesuanota.api.endpoint;


public class ApiError {

    private String error;

    public ApiError(final String error) {
        this.error = error;
    }

    public ApiError() {
    }

    public String getError() {
        return error;
    }

    public void setError(final String error) {
        this.error = error;
    }
}
