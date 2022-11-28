package com.demo.feing;

import com.demo.ententy.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "usuario-ms", url = "http://localhost:8083/usuarios")
public interface UsuarioFeignClient {

    @GetMapping("/email")
    Usuario findByEmail (@RequestParam String email);
}
