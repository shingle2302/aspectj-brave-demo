package com.shingle.aspectj.service;

import org.springframework.stereotype.Service;

@Service
public class AspectService {

    public String publicMethod() {
        privateMethod();
        return "publicMethod";
    }

    private String privateMethod() {
        return "privateMethod";
    }
}
