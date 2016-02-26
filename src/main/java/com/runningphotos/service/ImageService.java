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
        String pathToFile = "\\"+prefix+new Date().getTime()+".jpeg";
        try {
            File file = new File(path + pathToFile);
            FileUtils.writeByteArrayToFile(file,image.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pathToFile;
    }


    public String saveImage(MultipartFile image, String path)
    {
       return saveImage(image,path,"img_");
    }

}
