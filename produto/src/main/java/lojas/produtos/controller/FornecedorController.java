package lojas.produtos.controller;

import lojas.produtos.modulo.Fornecedor;
import lojas.produtos.servicos.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.lang.String.format;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    @Value("${server.port}")
    private int serverPort;

    @GetMapping
    public ResponseEntity<?> listar (){
        return ResponseEntity.ok(service.lista());
    }

    @GetMapping("{id}")
    public ResponseEntity<Fornecedor> buscaId(@PathVariable Long id){
        System.out.println(format("Servico rodando na porta: %s chamado.", serverPort));
        return ResponseEntity.ok(service.fornecedorId(id));
    }
    @PutMapping("/nome")
    @ResponseStatus(HttpStatus.CREATED)
    public void mudarNome (@RequestBody Fornecedor fornecedor){
        service.mudarNome(fornecedor);
    }

    @PostMapping
    public ResponseEntity<Fornecedor> adicionar (@RequestBody Fornecedor fornecedor){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.adicionar(fornecedor));
    }
}
