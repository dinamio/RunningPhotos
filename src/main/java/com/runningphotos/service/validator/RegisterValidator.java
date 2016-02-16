package com.runningphotos.service.validator;
/**
 * Created by ������� on 26.01.2016.
 */
import com.runningphotos.bom.Race;
import com.runningphotos.bom.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.awt.font.NumericShaper;

public class RegisterValidator implements Validator{
    @Autowired
    @Qualifier("emailValidator")
    EmailValidator emailValidator;
    public boolean supports(Class clazz) {
        return User.class.equals(clazz);
    }

    public void validate(Object o, Errors errors) {
        //Race race = (Race)o;
        User user = (User)o;
        ValidationUtils.rejectIfEmpty(errors, "login", "login.empty");
        ValidationUtils.rejectIfEmpty(errors, "city", "city.empty");
        ValidationUtils.rejectIfEmpty(errors, "mail", "mail.empty");
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "surname", "surname.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "password.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail.empty", "Please enter correct Email");
        if(user.getPassword().length()<6)
            errors.rejectValue("password","password.size");

        if(!emailValidator.valid(user.getMail())){
           errors.rejectValue("mail", "Pattern.mail","Please enter correct e-mail");
        }

    }
}
