package ru.leather.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.leather.onlineshop.service.OrrderService;

import java.util.Map;

@Controller
public class OrrderController {

    @Autowired
    private OrrderService orrderService;

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "/orders")
    public String orderAdmin(Map<String, Object> model){
        model.put("allOrder", orrderService.getAll());
        return "orders";
    }

    @RequestMapping(value = "/order")
    public String orderUser(Map<String, Object> model){
        model.put("myOrder", orrderService.getAll());
        return "order";
    }
}
