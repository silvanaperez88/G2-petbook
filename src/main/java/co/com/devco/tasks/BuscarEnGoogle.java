package co.com.devco.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static co.com.devco.userinterfaces.GoogleResultadosPage.RESULTADOS_BUSQUEDA;
import static co.com.devco.userinterfaces.GoogleSearchPage.CAMPO_BUSQUEDA;
import static co.com.devco.userinterfaces.GoogleSearchPage.GOOGLE_HOME_PAGE;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuscarEnGoogle implements Task {
    private String palabra;

    public BuscarEnGoogle(String palabra) {
        this.palabra = palabra;
    }

    public static Performable laPalabra(String palabra) {
        return instrumented(BuscarEnGoogle.class, palabra);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(GOOGLE_HOME_PAGE),
                Enter.theValue(palabra).into(CAMPO_BUSQUEDA),
                Hit.the(Keys.ENTER).into(CAMPO_BUSQUEDA),
                WaitUntil.the(RESULTADOS_BUSQUEDA, isVisible())
        );
    }
}
