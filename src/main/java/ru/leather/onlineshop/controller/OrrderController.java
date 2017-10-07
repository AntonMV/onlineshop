package ru.leather.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.leather.onlineshop.service.OrrderService;

import java.util.Map;

@Controller
public class OrrderController {

    @Autowired
    private OrrderService orrderService;

    @RequestMapping(value = "/orders")
    public String listProduct(Map<String, Object> model){
        model.put("myOrder", orrderService.getAll());
        return "orders";
    }
}
