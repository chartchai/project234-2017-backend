package camt.se234.project.controller;


import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

@CrossOrigin
@RestController
public class ImageController {
    Logger logger = Logger.getLogger(this.getClass());


    @Value("${physicalImageLocation}")
    String physicalImageLocation;
    //Save the uploaded file to this folder

    @Value("${imageServer}")
    String imageServer;
    private String UPLOADED_FOLDER;

    @PostConstruct
    public void init() {
        String prefix;
        String os = System.getProperty("os.name").toLowerCase();
        if (os.indexOf("win")>= 0){
            prefix = "C:";
        }else{
            prefix = System.getProperty("user.home");
        }

        UPLOADED_FOLDER = prefix + physicalImageLocation;
    }
    @GetMapping(
            value = "/images/{fileName:.+}",
            produces = {MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_PNG_VALUE})
    public @ResponseBody
    byte[] getImage(@PathVariable("fileName")String fileName) throws IOException {

        InputStream imageIn = this.getClass().getResourceAsStream("/images/"+fileName);
        return IOUtils.toByteArray(imageIn);
    }



}
