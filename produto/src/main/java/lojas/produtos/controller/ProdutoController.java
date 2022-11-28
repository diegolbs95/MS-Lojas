package lojas.produtos.controller;

import lojas.produtos.modulo.Produto;
import lojas.produtos.servicos.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<?> listar (){
        return ResponseEntity.ok(service.lista());
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Produto>> buscaId(@PathVariable Long id){
        return ResponseEntity.ok(service.produtoId(id));
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Produto> adicionar (@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.adicionar(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar (@PathVariable Long id, @RequestBody Produto produto){
        return ResponseEntity.ok(service.atualizar(id, produto));
    }
    @PutMapping("/vendas")
    public Produto vendaProdutos (@RequestBody  String nome, @RequestParam Integer quantidade) {
        return service.vendaProduto(nome, quantidade);
    }
}
