package com.devdiego.service;

import com.devdiego.entity.Usuario;
import com.devdiego.exception.UsuarioNaoExisteException;
import com.devdiego.model.UsuarioDto;
import com.devdiego.repositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.devdiego.utilidade.AppConstant.USUARIO_NAO_EXISTE;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositorio repositorio;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Usuario adicionarUsuario (Usuario usuario){
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return repositorio.save(usuario);
    }
    public Usuario usuarioId (Long id){

        return repositorio.findById(id).orElseThrow(() -> new UsuarioNaoExisteException(USUARIO_NAO_EXISTE));
    }

    public Usuario usuarioEmail (String email){
        var response = repositorio.findByEmail(email);
        return response;
    }
    public List<Usuario> findByNome (String nome) throws Exception {

        var usuarios = repositorio.findAll();

        usuarios.stream().filter(x -> x.getNome().equals(nome)).collect(Collectors.toList());
       if (usuarios.equals(nome)){
           return usuarios;
       }
       throw new Exception("Nao existe");
    }

    private UsuarioDto modificacao (Usuario usuario){
       return UsuarioDto.builder()
                .id(usuario.getId())
                .dateCompra(usuario.getDateCompra())
                .email(usuario.getEmail())
                .nome(usuario.getNome())
                .password(passwordEncoder.encode(usuario.getPassword()))
                .produtoComprado(usuario.getProdutoComprado())
                .build();
    }

}
