package com.runningphotos.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tensa on 06.02.2016.
 */
@Controller
public class BasketController {
    @RequestMapping(value = "/basket")
    public ModelAndView getBasket(){
        ModelAndView model = new ModelAndView("basket");
        return model;
    }
}
