package com.runningphotos.ui;

import javax.validation.Valid;
import com.runningphotos.bom.Race;
import com.runningphotos.dao.RaceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        if(binder.getTarget() instanceof Race) {
            binder.setValidator(raceValidator);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,true));
        }
    }

    @RequestMapping(value = "/addRace", method = RequestMethod.GET)
    public ModelAndView openAddRace() {
        ModelAndView model = new ModelAndView("admin/addRace");
        model.addObject("race",new Race());
        return model;
    }

    @RequestMapping(value = "/addRace", method = RequestMethod.POST)
    public ModelAndView addRace(@Valid Race race, BindingResult errors) {
        ModelAndView model = new ModelAndView("admin/addRace");
        raceValidator.validate(race,errors);
        if (errors.hasErrors()) {
            model.addAllObjects(errors.getModel());
        } else {
            raceDao.insert(race);
            model.addObject("race", new Race());
            model.addObject("msg", "Race was added successfully!");
        }
        return model;
    }
}
