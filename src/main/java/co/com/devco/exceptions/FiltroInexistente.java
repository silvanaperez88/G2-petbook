package co.com.devco.exceptions;

public class FiltroInexistente extends AssertionError {
    public static final String FILTRO_NO_EXISTENTE = "El filtro no existe";

    public FiltroInexistente(String message){
        super(message);
    }
}
