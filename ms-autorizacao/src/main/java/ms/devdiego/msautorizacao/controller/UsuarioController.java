package ms.devdiego.msautorizacao.controller;

import ms.devdiego.msautorizacao.Services.UsuarioService;
import ms.devdiego.msautorizacao.ententies.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/email")
    public ResponseEntity<Usuario> findByEmail (@RequestParam String email){
        try {
            var usuarioEmail = service.findByEmail(email);
            return ResponseEntity.ok(usuarioEmail);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
