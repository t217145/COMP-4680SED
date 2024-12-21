package comp4680sed.unit5.app05;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CustomErrorController {

    private static final Logger logger = LogManager.getLogger(CustomErrorController.class);

    @ExceptionHandler(IdNotFoundException.class)
    public ModelAndView handleException(IdNotFoundException e) {
        logger.error("Id not found");
        return new ModelAndView("customError", "ErrObject", e);
    }
}