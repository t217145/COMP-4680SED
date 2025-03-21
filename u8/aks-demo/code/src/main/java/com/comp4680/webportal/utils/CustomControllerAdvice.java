package com.comp4680.webportal.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import com.comp4680.webportal.models.CustomException;

@ControllerAdvice
public class CustomControllerAdvice {

    private final Logger logger = LoggerFactory.getLogger(CustomControllerAdvice.class);

    @ExceptionHandler(CustomException.class)
    public ModelAndView handleException(CustomException e) {
        logger.error(e.toString());
        return new ModelAndView("error", "ErrObject", e);
    }
}