package com.demo.controller;

import com.demo.ententy.Usuario;
import com.demo.feing.UsuarioFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usurs")
public class UsuarioController {

    @Autowired
    UsuarioFeignClient client;

    @GetMapping("/emal")
    public Usuario email (@RequestParam String email){
        return client.findByEmail(email);
    }
}
