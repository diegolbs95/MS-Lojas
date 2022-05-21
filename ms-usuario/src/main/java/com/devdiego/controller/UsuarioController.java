package com.devdiego.controller;

import com.devdiego.entity.Usuario;
import com.devdiego.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("{id}")
    public ResponseEntity<Usuario> findById (@PathVariable Long id){
        return ResponseEntity.ok(service.usuarioId(id));
    }

    @GetMapping("/email")
    public ResponseEntity<Usuario> findByEmail (@RequestParam String email){
        return ResponseEntity.ok(service.usuarioEmail(email));
    }

    @PostMapping
    public ResponseEntity<Usuario> adicionarUsuario (@RequestBody Usuario usuario){
       var response = service.adicionarUsuario(usuario);
       return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
