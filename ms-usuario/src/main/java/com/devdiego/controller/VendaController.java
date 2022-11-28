package com.devdiego.controller;

import com.devdiego.config.ProdutoFeignClient;
import com.devdiego.entity.Produto;
import com.devdiego.exception.UsuarioNaoExisteException;
import com.devdiego.repositories.UsuarioRepositorio;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import static com.devdiego.utilidade.AppConstant.USUARIO_NAO_EXISTE;

@RestController
@RequestMapping("/vendas")
@Log4j2
public class VendaController {

    @Autowired
    private ProdutoFeignClient client;
    @Autowired
    private UsuarioRepositorio repositorio;

    @PutMapping("/comprar/{id}")
    public ResponseEntity<?> comprarProduto (@RequestBody Produto produto, @RequestParam Integer quantidade,@PathVariable Long id){
       try {
            var cliente = repositorio.findById(id).orElseThrow(() -> new UsuarioNaoExisteException(USUARIO_NAO_EXISTE));
            var contador = cliente.getProdutoComprado() + quantidade;
            cliente.setDateCompra(LocalDateTime.now());
            cliente.setProdutoComprado(contador);
            client.vendaProdutos(produto, quantidade);
            log.info(String.format("Cliente %s, realizou a compra de %s do Produto: %s, Data: %s", cliente.getNome(), quantidade, produto.getNome(), cliente.getDateCompra()));
            return ResponseEntity.ok(repositorio.save(cliente));
       }catch (RuntimeException e){
         return ResponseEntity.ok(String.format(e.getMessage()));
       }
    }
}
