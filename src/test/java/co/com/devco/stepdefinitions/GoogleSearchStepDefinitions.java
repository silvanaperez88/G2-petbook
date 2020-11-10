package co.com.devco.stepdefinitions;

import co.com.devco.exceptions.ResultadoDeBusquedaInesperado;
import co.com.devco.questions.PrimerResultadoGoogle;
import co.com.devco.tasks.BuscarEnGoogle;
import io.cucumber.java.ast.Cuando;
import io.cucumber.java.es.Entonces;

import static co.com.devco.exceptions.ResultadoDeBusquedaInesperado.ENCONTRADO_OTRO_RESULTADO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GoogleSearchStepDefinitions {

    @Cuando("^(.*) busca (.*) en Google Search$")
    public void BuscaEnGoogleSearch(String actor, String palabra) {
        theActorCalled(actor).attemptsTo(
                BuscarEnGoogle.laPalabra(palabra)
        );
    }

    @Entonces("^debe ver como primer resultado (.*)$")
    public void debeVerComoPrimerResultado(String resultado) {
        theActorInTheSpotlight().should(seeThat(
                PrimerResultadoGoogle.es(resultado)).orComplainWith(
                        ResultadoDeBusquedaInesperado.class, ENCONTRADO_OTRO_RESULTADO
                )
        );
    }
}
