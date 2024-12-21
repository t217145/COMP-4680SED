package com.cyrus822.demo.web01.Utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import com.cyrus822.demo.web01.Models.CustomException;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleGeneral(Exception e){
        CustomException err = new CustomException("G001", e.getMessage(), "/index");
        return new ModelAndView("error", "errObj", err);
    }

    @ExceptionHandler(CustomException.class)
    public ModelAndView handleCustom(CustomException e){
        return new ModelAndView("error", "errObj", e);
    }
}