package com.runningphotos.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tensa on 06.02.2016.
 */
@Controller
public class BuyPhotosController {
        @RequestMapping(value = "/buyPhotos")
        public ModelAndView getBuyPhotos(){
            ModelAndView model = new ModelAndView("buyPhotos");
            return model;
        }
}
