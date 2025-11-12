package com.guilherme.livecoding.project_wallet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @GetMapping("/teste")
    public String exibir() {
        return "toncat iniciado agora";
    }

}
