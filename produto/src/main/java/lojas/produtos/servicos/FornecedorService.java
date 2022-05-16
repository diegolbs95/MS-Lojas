package lojas.produtos.servicos;

import lojas.produtos.modulo.Fornecedor;
import lojas.produtos.modulo.Produto;
import lojas.produtos.repositorio.FornecedorRepositorio;
import lojas.produtos.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
