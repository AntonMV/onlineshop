package ru.leather.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.leather.onlineshop.service.OrderService;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order")
    public String listProduct(Map<String, Object> model){
        model.put("myOrder", orderService.getAll());
        return "order";
    }
}
