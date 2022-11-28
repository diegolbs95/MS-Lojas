package ms.devdiego.msautorizacao.Services;

import lombok.extern.slf4j.Slf4j;
import ms.devdiego.msautorizacao.ententies.Usuario;
import ms.devdiego.msautorizacao.feignclients.UsuarioFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DetalheUsuarioServiceImpl {

    @Autowired
    private UsuarioFeignClient client;

//    public Usuario findByEmail (String email){
//        var usuario = client.findByEmail(email).getBody();
//        if (usuario == null ){
//            throw new IllegalArgumentException("Não existe usuario com email: "+ email);
//        }
//        return usuario;
//    }
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        var usuario = client.findByEmail(username).getBody();
//        if (usuario == null ){
//            log.error("Usuario com email: %s nao existe no banco de dados", username);
//            throw new UsernameNotFoundException("Não existe usuario com email: "+ username);
//        }
//        return usuario;
//    }
//
//    public List<Usuario> listUsuario (String nome) throws Exception {
//        var usuarios = client.findByNome(nome).getBody();
//        if (usuarios == null){
//            log.error("Nao existe nenhum usuario");
//            throw new Exception("Nao existe");
//        }
//        return usuarios;
//    }
}
