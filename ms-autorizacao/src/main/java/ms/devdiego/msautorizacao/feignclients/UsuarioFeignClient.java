package ms.devdiego.msautorizacao.feignclients;

import ms.devdiego.msautorizacao.ententies.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//@Component
@FeignClient(name = "usuario-ms", url = "http://localhost:8083/usuarios")
public interface UsuarioFeignClient {

    @GetMapping("/email")
    Usuario findByEmail (@RequestParam String email);

    @GetMapping(value = "/nomes")
    ResponseEntity<List<Usuario>> findByNome (@RequestParam String nome);
}
