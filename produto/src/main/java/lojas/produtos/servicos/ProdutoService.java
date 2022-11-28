package lojas.produtos.servicos;

import lojas.produtos.constants.TraceProdutoConstante;
import lojas.produtos.exception.EstoqueVazioException;
import lojas.produtos.exception.ProdutoNaoCadastradoException;
import lojas.produtos.exception.QuantidadeElevadaException;
import lojas.produtos.modulo.Produto;
import lojas.produtos.repositorio.ProdutoRepositorio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static lojas.produtos.constants.TraceProdutoConstante.PRODUTO_NAO_CADASTRADO_EM_ESTOQUE;

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
        BeanUtils.copyProperties(produto, produtoAtual, "id");
        return repositorio.save(produtoAtual);
    }

    public Produto vendaProduto (String nomeProduto, Integer quantidadeProduto) {
          var produto = buscarProduto(nomeProduto);
          log.info(String.format("Nome do produto %s", produto.getNomeProduto()));

          if (produto.getQuantidadeEstoque().equals(0)) throw new EstoqueVazioException(TraceProdutoConstante.PRODUTO_EM_FALTA_NO_ESTOQUE);

          if (produto.getQuantidadeEstoque() < quantidadeProduto) throw new QuantidadeElevadaException(TraceProdutoConstante.QUANTIDADE_EM_ESTOQUE);

          var quantidadeProdutoRestante = produto.getQuantidadeEstoque() - quantidadeProduto;
          produto.setQuantidadeEstoque(quantidadeProdutoRestante);
          return repositorio.save(produto);
}
    public Produto buscarProduto (String nomeProduto){
        return repositorio.findByNomeProduto(nomeProduto).orElseThrow(()
                -> new ProdutoNaoCadastradoException(PRODUTO_NAO_CADASTRADO_EM_ESTOQUE));
    }
    public Produto valorEstoque (Produto produto){
        return Produto.builder()
                .valorUnitario(produto.getValorUnitario())
                .quantidadeEstoque(produto.getQuantidadeEstoque())
                .nomeProduto(produto.getNomeProduto())
                .fornecedor(produto.getFornecedor())
                .valorEmEstoque(produto.getValorEmEstoque())
                .build();
    }
}
