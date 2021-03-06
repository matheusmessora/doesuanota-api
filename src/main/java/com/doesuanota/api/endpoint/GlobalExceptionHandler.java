package com.doesuanota.api.endpoint;


import com.doesuanota.api.infrastructure.json.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {


    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiError handleNotFoundException(final BadRequestException exc) {
        return new ApiError(exc);
    }
}
