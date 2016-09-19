package com.doesuanota.api.endpoint;


import com.doesuanota.api.domain.email.InvalidEmail;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {


    @ExceptionHandler(InvalidEmail.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiError handleNotFoundException(final InvalidEmail exception) {
        return new ApiError("Invalid e-mail");
    }
}
