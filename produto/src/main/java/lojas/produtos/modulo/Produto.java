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

    @Column(name = "tb_nome",nullable = false)
    private String nome;

    @Column(name = "tb_quantidade",nullable = false)
    private Integer quantidade;

    @Column(name = "tb_valor",nullable = false)
    private Double valor;

    @Column(name = "tb_total_estoque", nullable = false)
    private Double valorEstoque;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    public Double getTotal(){
       valorEstoque = quantidade * valor;
       return valorEstoque;
    }

}
