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
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Jimmy on 31.01.2016.
 */
@Controller
public class ImageController {

    @Value(value = "${path.to.file}")
    private String path;

    @Value(value = "${path.to.photo}")
    private String pathPhoto;

    @RequestMapping(value="/image/{imageAddress}", method = RequestMethod.GET)
    protected HttpEntity<byte[]> getImage(@PathVariable String imageAddress, HttpServletRequest request, Model model) throws IOException {
        return readBytes(path, imageAddress);
    }


    @RequestMapping(value="/photo/{imageAddress}", method = RequestMethod.GET)
    protected HttpEntity<byte[]> getPhoto(@PathVariable String imageAddress, HttpServletRequest request, Model model) throws IOException {
        return readBytes(pathPhoto, imageAddress);
    }


    @RequestMapping(value="/photo_s/{imageAddress}", method = RequestMethod.GET)
    protected HttpEntity<byte[]> getSmallPhoto(@PathVariable String imageAddress, HttpServletRequest request, Model model)throws IOException  {
        BufferedImage bufferedImage = ImageIO.read(new File(pathPhoto + "/" + imageAddress + ".jpeg"));
        bufferedImage = getCropImage( bufferedImage, 75, 75, true ) ;
        return readResizeBytes(bufferedImage);
    }


    @RequestMapping(value="/photo_m/{imageAddress}", method = RequestMethod.GET)
    protected HttpEntity<byte[]> getMediumPhoto(@PathVariable String imageAddress, HttpServletRequest request, Model model)throws IOException  {
        BufferedImage bufferedImage = ImageIO.read(new File(pathPhoto + "/" + imageAddress + ".jpeg"));
        bufferedImage = getCropImage( bufferedImage, 500, 500, false ) ;
        return readResizeBytes(bufferedImage);
    }


    private BufferedImage getCropImage(BufferedImage image, int width, int heigth, boolean crop){

        int finalwidth = width;
        int finalheigth = heigth;
        int shiftw = 0;
        int shifth = 0;
        double factor = 1.0d;

        if(crop) {

            if (image.getWidth() > image.getHeight()) {
                factor = ((double) image.getWidth() / (double) image.getHeight());
                finalwidth = (int) (finalheigth * factor);
                shiftw = Math.negateExact((finalwidth - finalheigth) / 2);
            } else {
                factor = ((double) image.getHeight() / (double) image.getWidth());
                finalheigth = (int) (finalwidth * factor);
                shifth = Math.negateExact((finalheigth - finalwidth) / 2);
            }

        } else{

            if(image.getWidth() > image.getHeight()){
                factor = ((double)image.getHeight()/(double)image.getWidth());
                finalheigth = (int)(finalwidth * factor);
                heigth = finalheigth;
            }else{
                factor = ((double)image.getWidth()/(double)image.getHeight());
                finalwidth = (int)(finalheigth * factor);
                width = finalwidth;
            }
        }

        int type = image.getType() == 0? BufferedImage.TYPE_INT_ARGB : image.getType();
        BufferedImage resizeImg = new BufferedImage(width, heigth, type);

        Graphics2D g2 = resizeImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(image, 0 + shiftw, 0 + shifth, finalwidth, finalheigth, null);
        g2.dispose();

        return resizeImg;
    }


    private HttpEntity<byte[]> readBytes(String path, String imageAddress) throws IOException{

        byte[] imageBytes  = Files.readAllBytes(Paths.get(path + "/" + imageAddress + ".jpeg"));
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(imageBytes.length);

        return new HttpEntity<byte[]>(imageBytes, headers);
    }


    private HttpEntity<byte[]> readResizeBytes(BufferedImage bufferedImage) throws IOException{

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        ImageIO.setUseCache(false);
        ImageIO.write( bufferedImage, "jpg", baos );

        baos.flush();
        byte[] imageBytes = baos.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(imageBytes.length);

        return new HttpEntity<byte[]>(imageBytes, headers);
    }




}
