package co.com.devco.questions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.Test;

import static co.com.devco.userinterfaces.PetBookPage.TITULO_PETBOOK;

public class InformacionPetBook implements Question<Boolean> {
    private final String titulo;

    public InformacionPetBook(String titulo){
        this.titulo = titulo;
    }

    public static InformacionPetBook es(String titulo){
        return new InformacionPetBook(titulo);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String tituloencontrado= Text.of(TITULO_PETBOOK).viewedBy(actor).asString();
       return tituloencontrado.equals(titulo);

    }

}
