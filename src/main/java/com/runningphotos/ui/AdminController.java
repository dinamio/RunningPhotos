package com.runningphotos.ui;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.runningphotos.bom.*;
import com.runningphotos.dao.NumberOnPhotoDao;
import com.runningphotos.dao.RaceDao;
import com.runningphotos.dao.RacePhotoDao;
import com.runningphotos.service.ImageService;
import com.runningphotos.util.TagPhotoUtils;
import org.apache.commons.io.IOUtils;
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

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Jimmy on 24.01.2016.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private NumberOnPhotoDao numberOnPhotoDao;

    @Autowired
    private RaceDao raceDao;

    @Autowired
    private Validator raceValidator;

    @Autowired
    private RacePhotoDao racePhotoDao;

    @Value(value = "${path.to.file}")
    private String path;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        if (binder.getTarget() instanceof Race) {
            binder.setValidator(raceValidator);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        }
    }


    @RequestMapping(value = "/tagPhotos", method = RequestMethod.GET)
    public ModelAndView openTagPhotos() {

        return TagPhotoUtils.openTagPhotos(racePhotoDao);
    }

    @RequestMapping(value = "/tagPhotos", method = RequestMethod.POST)
    public ModelAndView chooseTagPhotos(String marks) {

        return TagPhotoUtils.chooseTagPhotos(marks, racePhotoDao);
    }

    @RequestMapping(value = "/getMarkInPhoto", method = RequestMethod.GET)
    public @ResponseBody List<NumberOnPhoto> getTagPhotos(String id) {

        return TagPhotoUtils.getTagPhotos(id, numberOnPhotoDao);
    }

    @RequestMapping(value = "/setMarkInPhoto", method = RequestMethod.GET)
    public @ResponseBody String setTagPhotos(HttpServletRequest request) {

        return TagPhotoUtils.setTagPhotos(request,numberOnPhotoDao, racePhotoDao);
    }

    @RequestMapping(value = "/changeResults", method = RequestMethod.GET)
    public ModelAndView openChangeResults() {
        ModelAndView model = new ModelAndView("admin/changeResults");
        model.addObject("results", new Race());
        return model;
    }

    @RequestMapping(value = "/changeRace", method = RequestMethod.GET)
    public ModelAndView openСhangeRace() {
        ModelAndView model = new ModelAndView("admin/changeRace");
        model.addObject("race", new Race());
        return model;
    }


    @RequestMapping(value = "/addRace", method = RequestMethod.GET)
    public ModelAndView openAddRace() {
        ModelAndView model = new ModelAndView("admin/addRace");
        model.addObject("race", new Race());
        model.addObject("pLabel", "addracepadge.addRace");
        return model;
    }

    @RequestMapping(value = "/addRace", method = RequestMethod.POST)
    public ModelAndView addRace(Race race, BindingResult errors,
                                @RequestParam(value = "race-photo", required = false) MultipartFile image) {
        ModelAndView model = new ModelAndView("admin/addRace");
        raceValidator.validate(race, errors);
        if (errors.hasErrors()) {
            model.addAllObjects(errors.getModel());
        } else {
            if (image.getSize() > 0) {
                race.setPhoto(new ImageService().saveImage(image,path));
            }
            raceDao.insert(race);
            model.addObject("race", new Race());
            model.addObject("msg", "Race was added successfully!");
            model.addObject("pLabel", "addracepadge.addRace");
        }
        return model;
    }

    @RequestMapping(value = "/add/result", method = RequestMethod.GET)
    public ModelAndView getAddResultPage() {
        ModelAndView model = new ModelAndView("admin/result");
        List<Race> races =  raceDao.selectRacesWithoutResult();
        model.addObject("racesList", races);
        model.addObject("race", races.size()>0 ? races.get(0) : new Race());
        return model;
    }


    @RequestMapping(value = "/updateRace", method = RequestMethod.GET)
    public ModelAndView openUpdateRace() {
        ModelAndView model = new ModelAndView("admin/addRace");
        model.addObject("race", new Race());
        model.addObject("races", raceDao.selectAll());
        model.addObject("pLabel", "addracepadge.updateRace");
        return model;
    }


    @RequestMapping(value = "/updateRace", method = RequestMethod.POST)
    public ModelAndView updateRace(Race race, BindingResult errors,
                                   @RequestParam(value = "race-photo", required = false) MultipartFile image) {
        ModelAndView model = new ModelAndView("admin/addRace");
        raceValidator.validate(race, errors);
        if (errors.hasErrors()) {
            model.addAllObjects(errors.getModel());
        } else {
            if (!image.isEmpty()) {
                race.setPhoto(new ImageService().saveImage(image,path));
            }
            raceDao.update(race);
            model.addObject("race", race);
            model.addObject("races", raceDao.selectAll());
            model.addObject("msg", "Race was updated successfully!");
            model.addObject("pLabel", "addracepadge.updateRace");
        }
        return model;
    }


    @RequestMapping(value = "/getRaceById", method = RequestMethod.GET)
    public @ResponseBody  Race getRace(@RequestParam String raceId) {
        return raceDao.selectById(Integer.parseInt(raceId));
    }

}
