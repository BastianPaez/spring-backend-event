package com.eventipass.backend.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controllerxd {
    @GetMapping("/")
    public String test(){
        return "Hola mundo";
    }
}
