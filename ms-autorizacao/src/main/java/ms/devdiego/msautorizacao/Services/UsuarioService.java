package ms.devdiego.msautorizacao.Services;

import lombok.extern.log4j.Log4j2;
import ms.devdiego.msautorizacao.ententies.Usuario;
import ms.devdiego.msautorizacao.feignclients.UsuarioFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UsuarioService {

    @Autowired
    private UsuarioFeignClient client;

    public Usuario findByEmail (String email){
        var usuario = client.findByEmail(email);
        if (usuario == null ){
            log.error("Esse email não existe, adicione um email valido" + email);
            throw new IllegalArgumentException("Email nao existe");
        }
        log.info("Buscou email: %s no banco de dados" + email);
        return usuario.getBody();
    }


}
