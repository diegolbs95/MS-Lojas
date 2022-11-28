package com.devdiego.config;

import com.devdiego.entity.Produto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "produto-ms", url = "${PRODUTO.MS}")
public interface ProdutoFeignClient {

    @PutMapping("/vendas")
    Produto vendaProdutos (@RequestBody Produto produto, @RequestParam Integer quantidade);
}
