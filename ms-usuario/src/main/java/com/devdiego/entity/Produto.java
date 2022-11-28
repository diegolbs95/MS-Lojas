package com.devdiego.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Produto {

    private String nome;

    private Integer quantidadeEstoque;

    private Double valorUnitario;
}
