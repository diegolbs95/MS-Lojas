package ms.devdiego.msautorizacao.feignclients;

import ms.devdiego.msautorizacao.ententies.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "usuario-ms", path = "/usuarios")
public interface UsuarioFeignClient {

    @GetMapping(value = "/email")
    ResponseEntity<Usuario> findByEmail (@RequestParam String email);
}
