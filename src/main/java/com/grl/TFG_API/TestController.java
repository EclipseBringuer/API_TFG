package com.grl.TFG_API;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/welcome")
    public String welcomeMessage(){
        return "Lo hemos conseguido";
    }
}
