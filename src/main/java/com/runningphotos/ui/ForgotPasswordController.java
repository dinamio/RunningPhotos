package com.runningphotos.ui;

import com.runningphotos.bom.User;
import com.runningphotos.dao.UserDao;
import com.runningphotos.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * Created by Tensa on 06.02.2016.
 */
@Controller
public class ForgotPasswordController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    UserDao userDao;

    @Autowired
    private MailSenderService mailSenderService;

    @RequestMapping(value = "/forgotPassword",method = RequestMethod.GET)
    public ModelAndView getForgotPassword()
    {
        ModelAndView model = new ModelAndView("/forgotPassword");
        model.addObject("user",new User());
        return model;
    }

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public ModelAndView passwordRecovery(User user, Locale locale) {
        ModelAndView model = new ModelAndView("/forgotPassword");
        user=userDao.selectByMail(user);
        if(user==null) {
            model.addObject("notFoundMessage", messageSource.getMessage("forgotPassword.userNotFound", null, locale));
            return model;
        }

        String password = generateNewPassword();

        String mailHello =messageSource.getMessage("forgotPassword.hello", null, locale);
        String mailText =messageSource.getMessage("forgotPassword.mailText", null, locale);

        mailSenderService.sendMail("RunSnapShot",
                user.getMail(),
                mailHello+user.getLogin(),
                mailText+" "+password);
        user.setPassword(password);
        userDao.update(user);
        model.addObject("successfulMessage", messageSource.getMessage("forgotPassword.successful", null, locale));
        return model;
    }
    private String generateNewPassword(){
        char[] m = new char[26];
        String password="";
        for (int i=0; i< 26; i++) {
            m[i] = (char)('a' + i);
        }
        Random random = new Random();
        for(int j=0;j<9;j++){
            password+=m[random.nextInt(26)];
        }
        return password;
    }
}
