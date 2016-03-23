package com.runningphotos.ui;
import com.runningphotos.bom.NumberOnPhoto;
import com.runningphotos.dao.NumberOnPhotoDao;
import com.runningphotos.dao.RacePhotoDao;
import com.runningphotos.util.TagPhotoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Oleg on 23.03.2016.
 */
@Controller
@RequestMapping(value = "/operator")
public class OperatorController {

    @Autowired
    private NumberOnPhotoDao numberOnPhotoDao;

    @Autowired
    private RacePhotoDao racePhotoDao;

    @Value(value = "${path.to.file}")
    private String path;


    @RequestMapping(value = "/tagPhotos", method = RequestMethod.GET)
    public ModelAndView openTagPhotos() {
        return TagPhotoUtils.openTagPhotos(racePhotoDao);
    }

    @RequestMapping(value = "/tagPhotos", method = RequestMethod.POST)
    public ModelAndView chooseTagPhotos(String marks) {

        return TagPhotoUtils.chooseTagPhotos(marks, racePhotoDao);
    }

    @RequestMapping(value = "/getMarkInPhoto", method = RequestMethod.GET)
    public @ResponseBody
    List<NumberOnPhoto> getTagPhotos(String id) {

        return TagPhotoUtils.getTagPhotos(id, numberOnPhotoDao);
    }

    @RequestMapping(value = "/setMarkInPhoto", method = RequestMethod.GET)
    public @ResponseBody String setTagPhotos(HttpServletRequest request) {

        return TagPhotoUtils.setTagPhotos(request,numberOnPhotoDao, racePhotoDao);
    }
}
