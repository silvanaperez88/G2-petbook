package co.com.devco.exceptions;

public class ImagenInexistente extends AssertionError {
    public static final String ENCONTRADO_OTRA_IMAGEN = "La imagen obtenida no es la esperada";

    public ImagenInexistente(String message){
        super(message);
    }
}
