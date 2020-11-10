package co.com.devco.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ensure.web.ElementsLocated;

import static co.com.devco.userinterfaces.PetBookPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavegarAtras implements Task {

    public static Performable back() {
        return instrumented(NavegarAtras.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).getDriver().navigate().back();
    }
}
