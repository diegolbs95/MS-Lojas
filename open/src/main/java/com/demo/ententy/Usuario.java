package com.demo.ententy;

import lombok.Data;

@Data
public class Usuario {

    private Long id;

    private String nome;
    private String password;
    private String email;
}
