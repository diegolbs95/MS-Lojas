package com.devdiego.controller;

import com.devdiego.entity.Usuario;
import com.devdiego.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/nomes")
    public ResponseEntity<List<Usuario>> findByNome (@RequestParam String nome) throws Exception {
        try {
            var nomes = service.findByNome(nome);
            return ResponseEntity.ok(nomes);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> adicionarUsuario (@RequestBody Usuario usuario){
       try {
           var response = service.adicionarUsuario(usuario);
           return ResponseEntity.status(HttpStatus.CREATED).body(response);
       }catch (Exception e){
         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
    }


}
