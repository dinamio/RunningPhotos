package com.runningphotos.service;

import com.runningphotos.bom.Race;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Oleg on 19.02.2016.
 */
public class ImageService {


    public String saveImage(MultipartFile image, String path, String prefix){
        try {
            String pathToFile = "/"+prefix+new Date().getTime()+".jpeg";
            System.out.println(pathToFile);
            File file = new File(path + pathToFile);
            FileUtils.writeByteArrayToFile(file,image.getBytes());
            return pathToFile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }


    public void saveImage(MultipartFile image, String path){
        saveImage(image,path,"img_");
    }


    public void saveImage(Race race, MultipartFile image, String path, String prefix) {
        String pathToFile = saveImage(image, path, prefix);
        if (!pathToFile.equals("error"))
        {
            race.setPhoto(pathToFile);
        }
    }


    public void saveImage(Race race, MultipartFile image, String path) {
        saveImage(race, image, path, "img_");
    }
}
