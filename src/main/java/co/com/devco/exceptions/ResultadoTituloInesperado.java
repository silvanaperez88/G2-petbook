package co.com.devco.exceptions;

public class ResultadoTituloInesperado extends AssertionError {
    public static final String ENCONTRADO_OTRO_TITULO = "eL titulo no es el que se esperada";

    public ResultadoTituloInesperado(String message, Throwable cause){
        super(message, cause);
    }
}
