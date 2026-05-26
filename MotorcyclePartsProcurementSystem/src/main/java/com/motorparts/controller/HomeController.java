package com.motorparts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页重定向到 API 文档
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "redirect:/swagger-ui/index.html";
    }
}
