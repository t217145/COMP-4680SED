package com.cyrus822.demo.web01.Utils;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.cyrus822.demo.web01.Models.DemoModel;
import com.cyrus822.demo.web01.Repos.DemoRepo;

public class CustomValidator implements Validator {

    @Autowired
    private DemoRepo repo;

    @Override
    public boolean supports(@SuppressWarnings("null") Class<?> clazz) {
        return clazz.equals(DemoModel.class);
    }

    @Override
    public void validate(@SuppressWarnings("null") Object target, @SuppressWarnings("null") Errors errors) {
        DemoModel formObj = (DemoModel) target;
        String formValue1 = formObj.getValue1();
        Optional<DemoModel> dbObj = repo.findOneByValue1(formValue1);

        /*  only check create case. When update, same object with same value must already exist in DB */
        boolean isCreate = formObj.getId() == 0; 

        if(isCreate && dbObj.isPresent()){
            errors.rejectValue("value1", "Value 1 already exists in DB");
        }

        // throw general error message
        /* Check whether one of them exists */
        if(formObj.getValue2() == 0 && formObj.getValue3() == null){
            errors.reject("V001", "Either value 2 or value 3 must be provided");
        }//end of checking
    }//end of validate()
}//end of class