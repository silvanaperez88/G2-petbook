package co.com.devco.exceptions;

public class ResultadoDeBusquedaInesperado  extends AssertionError {
    public static final String ENCONTRADO_OTRO_RESULTADO = "El resultado obtenido no es el esperado";

    public ResultadoDeBusquedaInesperado(String message, Throwable cause){
        super(message, cause);
    }
}
