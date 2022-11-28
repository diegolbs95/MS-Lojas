package lojas.produtos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProdutoNaoCadastradoException extends RuntimeException{

    public ProdutoNaoCadastradoException(String mensagem){
        super(mensagem);
    }

    public ProdutoNaoCadastradoException(Long produto){
        this(String.format("Produto: %s, não cadastrado! ", produto));
    }

}
