package com.runningphotos.ui;

import com.runningphotos.bom.Race;
import com.runningphotos.bom.User;
import com.runningphotos.dao.UserDao;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by eugenegodun on 1/19/16.
 */
@Controller

public class RegisterController {

    @Autowired
    private Validator registerValidator;

    @Autowired
    private UserDao userDao;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        if(binder.getTarget() instanceof User) {
            binder.setValidator(registerValidator);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,true));
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView openRegisterPage() {
        ModelAndView model = new ModelAndView("/register");
        model.addObject("user",new User());
        return model;
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView getNewUser(@Valid User user, BindingResult errors,HttpServletRequest request) {
        String confirmPassword = request.getParameter("confirmPassword");
        ModelAndView model = new ModelAndView("/register");
        registerValidator.validate(user, errors);
        model.addAllObjects(errors.getModel());
        if(confirmPassword.equals(user.getPassword()))
            userDao.insert(user);
        else
            errors.rejectValue("password","password.sd","Password doesn't match");
        model.addObject("user", new User());
        if(!errors.hasErrors())
            model.addObject("msg", "Registration successfully completed");
        return model;
    }
}
