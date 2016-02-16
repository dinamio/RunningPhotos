package com.runningphotos.service.validator;

import com.runningphotos.bom.Race;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Jimmy on 24.01.2016.
 */
public class RaceValidator implements Validator{
    public boolean supports(Class clazz) {
        return Race.class.equals(clazz);
    }

    public void validate(Object o, Errors errors) {
        //Race race = (Race)o;
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "city", "city.empty");
        ValidationUtils.rejectIfEmpty(errors, "raceDate","race.date.error", "Race date must not be empty");
    }
}
