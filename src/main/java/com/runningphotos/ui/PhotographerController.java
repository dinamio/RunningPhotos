package com.runningphotos.ui;
import com.runningphotos.service.ImageService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Tensa on 09.02.2016.
 */
@Controller
@RequestMapping(value = "/photographer")
public class PhotographerController {

    @Value(value = "${path.to.photo}")
    private String path;


    @RequestMapping(value = "/uploadPhotos", method = RequestMethod.GET)
    public ModelAndView openUploadPhotos()
    {
        ModelAndView model = new ModelAndView("photographer/uploadPhotos");
        return model;
    }


    @RequestMapping(value = "/uploadPhotos", method = RequestMethod.POST)
    public void fuleUploadPhotos (@RequestParam(value = "photographer-photos", required = false) MultipartFile photo)
    {
       new ImageService().saveImage(photo, path, "photo_" );
    }


    public ModelAndView openMyPhotos()
    {
        ModelAndView model = new ModelAndView("photographer/myPhotos");
        return model;
    }

}