package br.com.xuiter.xuiter_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PiuController {

    @GetMapping("/piu")
    public String piu(){
        return "TESTE";
    }

}
