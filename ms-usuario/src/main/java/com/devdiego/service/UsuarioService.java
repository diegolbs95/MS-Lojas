package com.devdiego.service;

import com.devdiego.entity.Usuario;
import com.devdiego.repositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositorio repositorio;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Usuario adicionarUsuario (Usuario usuario){
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return repositorio.save(usuario);
    }

    public Usuario usuarioId (Long id){
        return repositorio.findById(id).get();
    }

    public Usuario usuarioEmail (String email){
        var response = repositorio.findByEmail(email);
        return response;
    }
}
