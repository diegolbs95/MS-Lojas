package lojas.produtos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class QuantidadeElevadaException extends RuntimeException{

    public QuantidadeElevadaException (String mensagem){
        super(mensagem);
    }

    public QuantidadeElevadaException (Long produtoId){
        this(String.format("Apenas %s unidades em estoque", produtoId));
    }
}
