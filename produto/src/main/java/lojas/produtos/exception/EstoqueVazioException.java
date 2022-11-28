package lojas.produtos.exception;

public class EstoqueVazioException extends RuntimeException{

    public EstoqueVazioException (String mensagem){
        super(mensagem);
    }

    public EstoqueVazioException (Long produto){
        this(String.format("Produto %s esta em falta no estoque", produto));
    }

}
