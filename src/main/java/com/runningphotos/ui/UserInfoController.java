package com.runningphotos.ui;

import com.runningphotos.bom.Race;
import com.runningphotos.bom.User;
import com.runningphotos.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import java.util.List;
import java.util.Locale;

/**
 * Created by ������� on 26.02.2016.
 */


@Controller
public class UserInfoController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserDao userDao;

    @Autowired
    private Validator registerValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        if (binder.getTarget() instanceof User) {
            binder.setValidator(registerValidator);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        }
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public ModelAndView getUserInfoPage() {
        ModelAndView model = new ModelAndView("updateUserInfo");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();//get logged in username
        User user = userDao.selectByUsername(username);
        model.addObject("user", user);
        return model;
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.POST)
    public ModelAndView updateUserInfo( User user,BindingResult errors, HttpServletRequest request, Locale locale) {
        String confirmPassword = request.getParameter("confirmPassword");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        String currentPassword = userDao.selectByUsername(username).getPassword();
        ModelAndView model = new ModelAndView("updateUserInfo");
        registerValidator.validate(user, errors);
        model.addAllObjects(errors.getModel());
        if (!errors.hasErrors()) {
            if(confirmPassword.equals("")) {
                userDao.update(user);
                model.addObject("msg", messageSource.getMessage("userInfo.updateSuccessful", null, locale));
            }
            else {
                if (confirmPassword.equals(currentPassword)) {
                    userDao.update(user);
                    model.addObject("msg", messageSource.getMessage("userInfo.updateSuccessful", null, locale));
                }
                else
                    errors.rejectValue("password", "password.sd", messageSource.getMessage("userInfo.incorrectCurrentPassword", null, locale));
            }
            model.addObject("user", user);
        }
        return model;
    }
}
