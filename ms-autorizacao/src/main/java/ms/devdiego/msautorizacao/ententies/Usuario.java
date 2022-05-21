package ms.devdiego.msautorizacao.ententies;

import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Data
public class Usuario {


    private Long id;

    private String nome;
    private String senha;
    private String email;

    private Set<Role> roles = new HashSet<>();

}
