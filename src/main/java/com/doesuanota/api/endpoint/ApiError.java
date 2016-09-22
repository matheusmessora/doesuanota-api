package com.doesuanota.api.endpoint;


import com.doesuanota.api.infrastructure.json.BadRequestException;
import com.google.common.base.CaseFormat;

public class ApiError {

    private String error;
    private String code;

    public ApiError(final BadRequestException exc) {
        this.error = exc.getError();
        this.code = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_HYPHEN, exc.getClass().getSimpleName());
    }

    public String getError() {
        return error;
    }

    public String getCode() {
        return code;
    }
}
