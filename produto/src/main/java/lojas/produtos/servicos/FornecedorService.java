package lojas.produtos.servicos;

import lojas.produtos.modulo.Fornecedor;
import lojas.produtos.modulo.Produto;
import lojas.produtos.repositorio.FornecedorRepositorio;
import lojas.produtos.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepositorio repositorio;

    public List<Fornecedor> lista (){
        return repositorio.findAll();
    }

    public Fornecedor fornecedorId (Long id){
        return repositorio.findById(id).get();
    }

    public Fornecedor adicionar (Fornecedor fornecedor){
        return repositorio.save(fornecedor);
    }

    public void mudarNome (Fornecedor nome){
        var fornecedores = repositorio.findAll();
        for (Fornecedor fornecedor: fornecedores) {
            fornecedor.setNome(nome.getNome());
            repositorio.save(fornecedor);
        }
    }
}
