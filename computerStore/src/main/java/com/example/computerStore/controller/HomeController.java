package com.example.computerStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage(){ return "index"; }

    @GetMapping("/contact")
    public String contactPage(){
        return "lienhe";
    }

    @GetMapping("/search")
    public String searchPage() { return "searchPage"; }

    @GetMapping("/product")
    public String detailProduct() { return "sanpham"; }
}
