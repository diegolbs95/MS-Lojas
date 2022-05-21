package com.devdiego.controller;

import com.devdiego.entity.Role;
import com.devdiego.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
@Slf4j
public class RoleController {

    @Autowired
    private RoleService service;

    @PostMapping
    public ResponseEntity<Role> adicionarRole (@RequestBody Role role){
        var response = service.adicionarUsuario(role);
        log.info(String.format("Role criada com o nome: %s", role.getNome()));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
