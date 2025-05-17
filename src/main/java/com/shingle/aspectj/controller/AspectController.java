package com.shingle.aspectj.controller;


import com.shingle.aspectj.service.AspectService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AspectController {
    private final AspectService aspectService;

    public AspectController(AspectService aspectService) {
        this.aspectService = aspectService;
    }

    @RequestMapping("/publicMethod")
    public String publicMethod() {
        return aspectService.publicMethod();
    }
}
