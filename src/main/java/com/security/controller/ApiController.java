package com.security.controller;

import com.security.service.ApiService;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(path = "/api")
public class ApiController {

    private final ApiService apiService;


    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping(path = "")
    public String getApi() {
        return apiService.getApod();
    }

    @PostMapping(path = "/scrapping")
    public String saveApod() {
        return apiService.scrapeApod();
    }
}
