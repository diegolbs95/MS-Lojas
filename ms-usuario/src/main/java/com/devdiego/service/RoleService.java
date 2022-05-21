package com.devdiego.service;

import com.devdiego.entity.Role;
import com.devdiego.entity.Usuario;
import com.devdiego.repositories.RoleRepositorio;
import com.devdiego.repositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepositorio repositorio;

    public Role adicionarUsuario (Role role){
        return repositorio.save(role);
    }

}
