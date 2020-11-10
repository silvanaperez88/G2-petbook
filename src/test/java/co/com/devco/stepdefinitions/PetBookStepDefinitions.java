package co.com.devco.stepdefinitions;


import co.com.devco.tasks.FiltrarImagen;
import co.com.devco.tasks.NavegarAtras;
import co.com.devco.tasks.SeleccionarImagen;
import io.cucumber.java.ast.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ensure.web.ElementsLocated;
import org.junit.Test;

import static co.com.devco.userinterfaces.PetBookPage.*;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class PetBookStepDefinitions {

    @Test
    @Cuando("^(.*) selecciona una imagen de \"(.*)\" para verla ampliada$")
    public void seleccionarImagen(String actorName, String img) {
        theActorCalled(actorName).attemptsTo(
                Open.url("http://localhost:4200/"),
                SeleccionarImagen.seleccionarImagen(img),
                NavegarAtras.back(),
                Switch.toActiveElement()
        );
    }

    @Y("^selecciona el filtro \"(.*)\"")
    public void filtro(String filtro){
        theActorInTheSpotlight().attemptsTo(
                FiltrarImagen.elFiltro(filtro)
        );
    }

    @Entonces("en la galeria solo debe haber {int} imagenes relacionadas al filtro seleccionado")
    public void imagenesDelFiltro(Integer cantidad) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.thatTheSetOf(ElementsLocated.by(LISTA_IMAGENES)).hasSize(cantidad)
        );
    }

    @Test
    @Cuando("^(.*) escoge el filtro \"(.*)\", luego selecciona una imagen de \"(.*)\"")
    public void filtroYSeleccion(String actorName, String filtro, String img) {
        theActorCalled(actorName).attemptsTo(
                Open.url("http://localhost:4200/"),
                FiltrarImagen.elFiltro(filtro),
                SeleccionarImagen.seleccionarImagen(img)
        );
    }
    @Entonces("solo se debe ver una imagen ampliada")
    public void resultadoSeleccion() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(IMAGEN_DETALLE).isDisplayed()
        );
    }

    @Test
    @Cuando("^(.*) selecciona el filtro \"(.*)\"")
    public void filtroGato(String actorName,String filtro){
        theActorCalled(actorName).attemptsTo(
                Open.url("http://localhost:4200/"),
                 FiltrarImagen.elFiltro(filtro)
        );
    }

    @Entonces("^al seleccionar el filtro \"(.*)\" deben estar todas las imagenes$")
    public void sumaImagenesFiltro(String filtro){
        theActorInTheSpotlight().attemptsTo(
        FiltrarImagen.elFiltro(filtro),
        Ensure.thatTheSetOf(ElementsLocated.by(LISTA_IMAGENES)).hasSize(5)
        );
    }
}
