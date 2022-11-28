package com.devdiego.model;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Builder
public class UsuarioDto {

    private Long id;
    private String nome;
    private String password;
    private String email;
    private int produtoComprado = 0;
    private LocalDateTime dateCompra;
}
