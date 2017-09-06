package ru.leather.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.leather.onlineshop.service.ProductService;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    @Qualifier(value = "productServiceImpl")
    public void setUserService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String listUsers(Model model){
        model.addAttribute("allProduct", productService.getAll());
        return "product";
    }
}
