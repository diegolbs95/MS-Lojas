package ms.devdiego.msautorizacao.controller;

import lombok.extern.slf4j.Slf4j;
import ms.devdiego.msautorizacao.Services.DetalheUsuarioServiceImpl;
import ms.devdiego.msautorizacao.ententies.Usuario;
import ms.devdiego.msautorizacao.feignclients.UsuarioFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Slf4j
public class UsuarioController {

    @Autowired
    private DetalheUsuarioServiceImpl service;
    @Autowired
    private UsuarioFeignClient client;

    @GetMapping("/email")
    public ResponseEntity<Usuario> findByEmail(@RequestParam String email) {
                try {
            var usuarioEmail = client.findByEmail(email);
            log.info("Buscou na base usuario com email: " + email);
            return ResponseEntity.ok(usuarioEmail);
        }catch (IllegalArgumentException e){
            log.error("Usuario não existe com email: " + email);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

//    @GetMapping("/email")
//    public ResponseEntity<?> findByEmail (@RequestParam String email){
//        try {
//            var usuarioEmail = service.loadUserByUsername(email);
//            log.info("Buscou na base usuario com email: " + email);
//            return ResponseEntity.ok(usuarioEmail);
//        }catch (IllegalArgumentException e){
//            log.error("Usuario não existe com email: " + email);
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
//
//    @GetMapping("/nomes")
//    public ResponseEntity<?> listNomes (@RequestParam String nome){
//        try {
//            var nomes = service.listUsuario(nome);
//            log.info("Buscou na base");
//            return ResponseEntity.ok(nomes);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
}
