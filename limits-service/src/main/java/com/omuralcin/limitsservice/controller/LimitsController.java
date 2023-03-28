package com.omuralcin.limitsservice.controller;

import com.omuralcin.limitsservice.bean.Limits;
import com.omuralcin.limitsservice.configuration.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    private final Configuration configuration;

    public LimitsController(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping("/limits")
    public Limits retrieveLimits(){
        return new Limits(configuration.getMinimum(),configuration.getMaximum());
    }
}
