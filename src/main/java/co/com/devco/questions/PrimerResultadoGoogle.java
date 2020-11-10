package co.com.devco.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Attribute;

import static co.com.devco.userinterfaces.GoogleResultadosPage.PRIMER_RESULTADO;

public class PrimerResultadoGoogle implements Question<Boolean> {
    private final String resultado;

    public PrimerResultadoGoogle(String resultado){
        this.resultado = resultado;
    }

    public static PrimerResultadoGoogle es(String resultado){
        return new PrimerResultadoGoogle(resultado);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String resultadoEncontrado = Attribute.of(PRIMER_RESULTADO).named("href").viewedBy(actor).asString();
        return resultadoEncontrado.contains(resultado);
    }
}
