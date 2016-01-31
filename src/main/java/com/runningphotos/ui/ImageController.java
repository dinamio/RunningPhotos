package com.runningphotos.ui;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Jimmy on 31.01.2016.
 */
@Controller
public class ImageController {

    @Value(value = "${path.to.file}")
    private String path;

    @RequestMapping(value="/image/{imageAddress}", method = RequestMethod.GET)
    protected HttpEntity<byte[]> getImage(@PathVariable String imageAddress, HttpServletRequest request, Model model) throws IOException {
        byte[] imageBytes  = Files.readAllBytes(Paths.get(path + "/" + imageAddress + ".jpeg"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(imageBytes.length);
        return new HttpEntity<byte[]>(imageBytes, headers);
    }
}
