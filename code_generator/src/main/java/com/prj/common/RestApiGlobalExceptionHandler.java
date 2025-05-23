package com.prj.common;
import com.prj.util.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class RestApiGlobalExceptionHandler {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    @ExceptionHandler(ApplicationException.class)
    @ResponseBody
    public RestApiResult whenApplicationExceptionThrown(ApplicationException e) {
        logger.warn(e.getMessage(),e.getStackTrace());
        return RestApiResult.fail(2, e.getMessage());
    }
}
