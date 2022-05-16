package lojas.produtos.servicos;

import lojas.produtos.modulo.Produto;
import lojas.produtos.repositorio.ProdutoRepositorio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepositorio repositorio;

    public List<Produto> lista (){
        return repositorio.findAll();
    }

    public Optional<Produto> produtoId (Long id){
        return repositorio.findById(id);
    }

    public Produto adicionar (Produto produto){
        return repositorio.save(valorEstoque(produto));
    }

    public Produto atualizar (Long id, Produto produto){
        var produtoAtual = repositorio.getById(id);
        BeanUtils.copyProperties(valorEstoque(produto), produtoAtual, "id");
        return repositorio.save(produtoAtual);
    }

    public Produto valorEstoque (Produto produto){
        return Produto.builder()
                .valor(produto.getValor())
                .quantidade(produto.getQuantidade())
                .nome(produto.getNome())
                .fornecedor(produto.getFornecedor())
                .valorEstoque(produto.getTotal())
                .build();
    }
}
