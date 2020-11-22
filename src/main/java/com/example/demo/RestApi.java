package com.example.demo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/")
public class RestApi {


    @CrossOrigin
    @JsonAnyGetter
    @GetMapping
    public String showCPU() {

        return "Hola mundo";
    }
}
