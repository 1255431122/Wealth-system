package com.wealth.web;

import com.wealth.pojo.ProductPojo;
import com.wealth.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductCtrl {
    @Autowired
    private IProductService productService;

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("productlist")
    public String productlist(ProductPojo productPojo, Model model){
        List<ProductPojo> productPojos= productService.getProducts(productPojo);

        model.addAttribute("products",productPojos);

        return "productlist";
    }
}
