package lojas.produtos.repositorio;

import lojas.produtos.modulo.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepositorio extends JpaRepository<Fornecedor, Long> {
}
