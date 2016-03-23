package com.runningphotos.util;

import com.runningphotos.bom.NumberOnPhoto;
import com.runningphotos.bom.RacePhoto;
import com.runningphotos.dao.NumberOnPhotoDao;
import com.runningphotos.dao.RacePhotoDao;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Oleg on 21.03.2016.
 */
public class TagPhotoUtils {


    public static ModelAndView openTagPhotos(RacePhotoDao racePhotoDao) {

        ModelAndView model = new ModelAndView("/tagPhotos");

        List<RacePhoto> photos = racePhotoDao.selectByMark(false);
        model.addObject("photos",photos);

        return model;
    }


    public static ModelAndView chooseTagPhotos(String marks, RacePhotoDao racePhotoDao) {

        ModelAndView model = new ModelAndView("/tagPhotos");
        List<RacePhoto> photos = null;

        if(marks.equals("unmarked")){
            photos = racePhotoDao.selectByMark(false);
        } else {
            photos = racePhotoDao.selectByMark(true);
        }

        model.addObject("photos",photos);
        model.addObject("marks",marks);

        return model;
    }


    public static String setTagPhotos(HttpServletRequest request, NumberOnPhotoDao numberOnPhotoDao, RacePhotoDao racePhotoDao) {

        int photoId = Integer.parseInt(request.getParameter("photoID"));
        JSONArray jsonArr = new JSONArray(request.getParameter("marks"));

        Set<String> marksStrArr = getStringArray(jsonArr);
        numberOnPhotoDao.deleteAllByPhotoId(photoId);
        insertMarks(marksStrArr, photoId, numberOnPhotoDao);

        RacePhoto racePhoto = racePhotoDao.selectById(photoId);
        racePhoto.setMark(true);
        racePhotoDao.update(racePhoto);

        return "true";
    }


    public static List<NumberOnPhoto> getTagPhotos(String id, NumberOnPhotoDao numberOnPhotoDao) {
        return numberOnPhotoDao.selectAllByPhotoId(Integer.parseInt(id));
    }


    private static void insertMarks(Set<String> marks, int photoId,NumberOnPhotoDao numberOnPhotoDao){

        NumberOnPhoto numberOnPhoto = new NumberOnPhoto();
        RacePhoto racePhoto= new RacePhoto();

        racePhoto.setId(photoId);
        for(String mark : marks ){
            numberOnPhoto.setNumber(mark);
            numberOnPhoto.setRacePhoto(racePhoto);
            numberOnPhotoDao.insert(numberOnPhoto);
        }
    }

    private static Set<String> getStringArray(JSONArray jsonArray){
        Set<String> stringArray = new TreeSet<String>();
        if(jsonArray!=null){
            int length = jsonArray.length();
            for(int i=0;i<length;i++){
                stringArray.add(jsonArray.getString(i).trim());
            }
        }
        return stringArray;
    }

}
