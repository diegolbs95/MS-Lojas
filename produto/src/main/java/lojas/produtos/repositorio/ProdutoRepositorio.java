package lojas.produtos.repositorio;

import lojas.produtos.modulo.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {
    Optional<Produto> findByNomeProduto (String nomeProduto);
}
