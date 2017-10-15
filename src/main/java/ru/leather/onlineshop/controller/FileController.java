package ru.leather.onlineshop.controller;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Controller
public class FileController {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(FileController.class);


    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                File loadFile = new File("C:\\img" + File.separator + file.getOriginalFilename());
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(String.valueOf(loadFile))));
                logger.info("uploaded: " + loadFile.getAbsolutePath());
                stream.write(bytes);
                stream.close();
                return "redirect:/users";
            } catch (Exception e) {
                return "404";
            }
        } else {
            return "404";
        }
    }

}

