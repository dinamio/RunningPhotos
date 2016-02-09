package com.runningphotos.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tensa on 09.02.2016.
 */
@Controller
@RequestMapping(value = "/photographer")
public class PhotographerController {

    public ModelAndView openUploadPhotos()
    {
        ModelAndView model = new ModelAndView("photographer/uploadPhotos");
        return model;
    }

    public ModelAndView openMyPhotos()
    {
        ModelAndView model = new ModelAndView("photographer/myPhotos");
        return model;
    }
}