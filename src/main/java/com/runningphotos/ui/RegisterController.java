package com.runningphotos.ui;

import com.runningphotos.bom.Runner;
import com.runningphotos.bom.User;
import com.runningphotos.dao.RunnerDao;
import com.runningphotos.dao.UserDao;
import com.runningphotos.service.RunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by eugenegodun on 1/19/16.
 */
@Controller

public class RegisterController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private RunnerService runnerService;

    @Autowired
    private RunnerDao runnerDao;

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
    public ModelAndView getNewUser(User user, BindingResult errors,HttpServletRequest request, Locale locale) {

        String confirmPassword = request.getParameter("confirmPassword");
        Runner runner = new Runner();
        String runnerSurnameAndName = request.getParameter("runnerSurnameAndName");
        runner = runnerService.getLinkedRunner(runnerSurnameAndName);
        user.setRunner(runner);
        ModelAndView model = new ModelAndView("/register");
        registerValidator.validate(user, errors);
        model.addAllObjects(errors.getModel());
        if(!errors.hasErrors()) {
            if (confirmPassword.equals(user.getPassword())){
                userDao.insert(user);
                System.out.println(user.getLogin()+" "+user.getRunner().getId());
                model.addObject("msg", messageSource.getMessage("register.successfully",null,locale));}
            else{
                errors.rejectValue("password", "password.sd", messageSource.getMessage("register.passNotMath", null, locale));}
            model.addObject("user", new User());
        }
        return model;
    }
}

