package com.park.backend.restful.service.backendrestfulservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "Home Server!";
    }

    @GetMapping("/profile")
    public String profile() {
        return "Profile Server Secured!";
    }


    @GetMapping("/user")
    public String user() {
        return "User Server Secured!";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Admin Server Secured!";
    }
}
