package com.devdiego.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.devdiego.utilidade.AppConstant.USUARIO_NAO_EXISTE;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNaoExisteException extends RuntimeException{

    public UsuarioNaoExisteException (String mensagem) {
        super(mensagem);
    }
}
