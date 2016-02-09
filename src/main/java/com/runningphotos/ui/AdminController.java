package com.runningphotos.ui;

import com.runningphotos.bom.Race;
import com.runningphotos.dao.RaceDao;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jimmy on 24.01.2016.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private RaceDao raceDao;

    @Autowired
    private Validator raceValidator;

    @Value(value = "${path.to.file}")
    private String path;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        if(binder.getTarget() instanceof Race) {
            binder.setValidator(raceValidator);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,true));
        }
    }

    @RequestMapping(value = "/tagPhotos", method = RequestMethod.GET)
    public ModelAndView openTagPhotos() {
        ModelAndView model = new ModelAndView("admin/tagPhotos");
        return model;
    }

    @RequestMapping(value = "/changeResults", method = RequestMethod.GET)
    public ModelAndView openChangeResults() {
        ModelAndView model = new ModelAndView("admin/changeResults");
        model.addObject("results",new Race());
        return model;
    }

    @RequestMapping(value = "/changeRace", method = RequestMethod.GET)
    public ModelAndView openСhangeRace() {
        ModelAndView model = new ModelAndView("admin/changeRace");
        model.addObject("race",new Race());
        return model;
    }

    @RequestMapping(value = "/addResults", method = RequestMethod.GET)
    public ModelAndView openAddResults() {
        ModelAndView model = new ModelAndView("admin/addResults");
        model.addObject("results",new Race());
        return model;
    }

    @RequestMapping(value = "/addRace", method = RequestMethod.GET)
    public ModelAndView openAddRace() {
        ModelAndView model = new ModelAndView("admin/addRace");
        model.addObject("race",new Race());
        return model;
    }

    @RequestMapping(value = "/addRace", method = RequestMethod.POST)
    public ModelAndView addRace(Race race, BindingResult errors,
                                @RequestParam(value = "race-photo", required = false) MultipartFile image) {
        ModelAndView model = new ModelAndView("admin/addRace");
        raceValidator.validate(race,errors);
        if (errors.hasErrors()) {
            model.addAllObjects(errors.getModel());
        } else {
            if(image.getSize()>0) {
                saveImage(race, image);
            }
            raceDao.insert(race);
            model.addObject("race", new Race());
            model.addObject("msg", "Race was added successfully!");
        }
        return model;
    }
    @RequestMapping(value = "/updateRace")
    public ModelAndView updateRace(){
        ModelAndView model = new ModelAndView("/admin/updateRace");
        return model;
    }


    private void saveImage(Race race, MultipartFile image) {
        try {
            String pathToFile = "/img_"+new Date().getTime()+".jpeg";
            File file = new File(path + pathToFile);
            FileUtils.writeByteArrayToFile(file,image.getBytes());
            race.setPhoto(pathToFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
