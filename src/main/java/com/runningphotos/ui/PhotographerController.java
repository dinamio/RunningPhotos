package com.runningphotos.ui;
import com.runningphotos.bom.Race;
import com.runningphotos.bom.RacePhoto;

import com.runningphotos.dao.RaceDao;
import com.runningphotos.dao.RacePhotoDao;
import com.runningphotos.dao.UserDao;
import com.runningphotos.service.ImageService;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Tensa on 09.02.2016.
 */
@Controller
@RequestMapping(value = "/photographer")
public class PhotographerController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RaceDao raceDao;

    @Autowired
    private RacePhotoDao racePhotoDao;

    @Value(value = "${path.to.photo}")
    private String path;


    @RequestMapping(value = "/uploadPhotos", method = RequestMethod.GET)
    public ModelAndView openUploadPhotos()
    {
        ModelAndView model = new ModelAndView("photographer/uploadPhotos");
        model.addObject("races", raceDao.selectAll());
        return model;
    }


    @RequestMapping(value = "/uploadPhotos", method = RequestMethod.POST)
    public ModelAndView fuleUploadPhotos (@RequestParam(value = "photographer-photos", required = false) MultipartFile photo,
                                          @RequestParam(value = "raceId", required = false) String id,
                                          Principal principal)
    {
        User activeUser = (User) ((Authentication) principal).getPrincipal();
        if (!photo.isEmpty()) {
            RacePhoto racePhoto= new RacePhoto();
            racePhoto.setRace(raceDao.selectById(Integer.valueOf(id)));
            racePhoto.setUser(userDao.selectByUsername(activeUser.getUsername()));
            racePhoto.setPath(new ImageService().saveImage(photo, path, "photo_" ));
            racePhotoDao.insert(racePhoto);
        }
        ModelAndView model = new ModelAndView("photographer/uploadPhotos");
        model.addObject("races", raceDao.selectAll());
        return model;
    }


    @RequestMapping(value = "/myPhotos", method = RequestMethod.GET)
    public ModelAndView openMyPhotos(Principal principal)
    {
        User activeUser = (User) ((Authentication) principal).getPrincipal();
        com.runningphotos.bom.User userName = userDao.selectByUsername(activeUser.getUsername());

        List<RacePhoto> racePhotosArr = racePhotoDao.getAllAuthorPhotos(userName);

        ModelAndView model = new ModelAndView("photographer/myPhotos");
        model.addObject("photos",dividedByRace(racePhotosArr).entrySet());

        return model;
    }

    private Map<String,List<RacePhoto>> dividedByRace(List<RacePhoto> racePhotosArr){
        Collections.sort(racePhotosArr,new Comparator<RacePhoto>() {
            public int compare(RacePhoto o1, RacePhoto o2) {
                return o1.getRace().getId() - o2.getRace().getId();
            }
        });

        Iterator<RacePhoto> racePhotoIterator = racePhotosArr.iterator();
        Map<String,List<RacePhoto>> racePhotoMap = new TreeMap<String,List<RacePhoto>>();

        if(racePhotoIterator.hasNext()) {

            RacePhoto racePhoto = racePhotoIterator.next();
            int start = 0;
            int finish = 0;

            while (racePhotoIterator.hasNext()){

                String raceName = raceDao.selectById(racePhoto.getRace().getId()).getName();
                start = racePhotosArr.indexOf(racePhoto);

                for(int i = racePhoto.getRace().getId() ;
                    racePhotoIterator.hasNext() && i == racePhoto.getRace().getId();
                    racePhoto = racePhotoIterator.next());

                if(racePhotoIterator.hasNext()) {
                    finish = racePhotosArr.indexOf(racePhoto);
                } else {
                    finish = racePhotosArr.size();
                }

                racePhotoMap.put(raceName,racePhotosArr.subList(start,finish) );
            }
        }
        return racePhotoMap;
    }

}