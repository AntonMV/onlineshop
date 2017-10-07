package ru.leather.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.leather.onlineshop.service.ProductService;

import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

//    @Autowired
//    @Qualifier(value = "productServiceImpl")
//    public void setProductService(ProductService productService) {
//        this.productService = productService;
//    }

    @RequestMapping(value = "/products")
    public String listProduct(Map<String, Object> model){
        model.put("allProduct", productService.getAll());
        model.put("Hello","Hello Anton");
        return "products";
    }
}
