package lojas.produtos.modulo;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_produto")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "nome",nullable = false)
    private String nomeProduto;

    @Column(name = "quantidade_estoque",nullable = false)
    private Integer quantidadeEstoque;

    @Column(name = "valor_unitario",nullable = false)
    private Double valorUnitario;

    @Column(name = "valor_em_estoque", nullable = false)
    private Double valorEmEstoque ;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    public Double getValorEmEstoque() {
        valorEmEstoque = quantidadeEstoque * valorUnitario;
        return valorEmEstoque;
    }

}
