package ru.leather.onlineshop.controller;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.leather.onlineshop.model.User;
import ru.leather.onlineshop.service.UserService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class FileController {

    @Autowired
    private UserService userService;

    private static final Logger logger = (Logger) LoggerFactory.getLogger(FileController.class);

    @Transactional
    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public String handleFileUploadUserAvatar(@RequestParam("file") MultipartFile file, @ModelAttribute("objUser") User objUser) throws IOException {
        if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();

                String rootpath = System.getProperty("catalina.home");
                String dirpath = File.separator +"images" + File.separator + "profile";
                File dir = new File(rootpath + dirpath);
                if (!dir.exists()){
                    dir.mkdirs();
                }
                String filename = objUser.getId() + "_" + file.getOriginalFilename();
                File loadFile = new File(dir + File.separator + filename);
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(String.valueOf(loadFile))));
                stream.write(bytes);
                stream.close();

                userService.addUserAvatar(objUser, dirpath + File.separator + filename);
                logger.info("uploaded user avatar: " + dirpath + File.separator + filename);
        }
        return "redirect:/users";
    }

}

