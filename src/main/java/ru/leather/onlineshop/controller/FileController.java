package ru.leather.onlineshop.controller;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.leather.onlineshop.model.User;
import ru.leather.onlineshop.service.UserService;
import ru.leather.onlineshop.utils.ArbitraryResourceLoader;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Pattern;

import static ru.leather.onlineshop.utils.NullOrEmpty.IsNullOrEmpty;

@Controller
public class FileController {

    @Autowired
    private UserService userService;

    @Autowired
    private ArbitraryResourceLoader resourceLoader;

    private static final Logger logger = (Logger) LoggerFactory.getLogger(FileController.class);

    @Transactional
    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public String handleFileUploadUserAvatar(@RequestParam("file") MultipartFile file, @ModelAttribute("objUser") User objUser) throws IOException {
        if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();

                Resource rootpath = resourceLoader.getResource("resources");
                logger.info("uploaded rootpath: " + rootpath.getFile().getAbsolutePath());
                String dirpath = File.separator +"img" + File.separator + "profile";
                File dir = new File(rootpath.getFile().getAbsolutePath() + dirpath);
                if (!dir.exists()){
                    dir.mkdirs();
                }

                if (!IsNullOrEmpty(userService.getByIdUser(objUser.getId()).getContact().getAvatar())){
                        File dirdel = new File(rootpath.getFile().getAbsolutePath() + File.separator + userService.getByIdUser(objUser.getId()).getContact().getAvatar());
                        logger.info("Delete file: " + dirdel);
                        dirdel.delete();
                }

                logger.info("uploaded dir: " + dir);
                String filename = objUser.getId() + "_" + file.getOriginalFilename();
                File loadFile = new File(dir + File.separator + filename);
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(String.valueOf(loadFile))));
                stream.write(bytes);
                stream.close();
                String url = "img" + "/" + "profile" + "/" + filename;
                userService.addUserAvatar(objUser, url);
                logger.info("uploaded user avatar: " + url);
        }
        return "redirect:/users";
    }

}

