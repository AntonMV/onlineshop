package ru.leather.onlineshop.controller;

import ch.qos.logback.classic.Logger;
import org.apache.commons.fileupload.FileUploadBase;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(FileController.class);

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNoHandlerFoundException(Exception ex) {
        logger.error("error handleNoHandlerFoundException: " +ex.getMessage());
        return "404";
    }

    @ExceptionHandler({IOException.class, FileUploadBase.SizeLimitExceededException.class})
    public String handleIOException(Exception ex) {
        logger.error("error IOException: " +ex.getMessage());
        return "redirect:/users";
    }
}
