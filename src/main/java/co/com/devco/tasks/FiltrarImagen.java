package co.com.devco.tasks;

import co.com.devco.exceptions.FiltroInexistente;
import co.com.devco.exceptions.ImagenInexistente;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ensure.web.ElementsLocated;

import static co.com.devco.exceptions.FiltroInexistente.FILTRO_NO_EXISTENTE;
import static co.com.devco.exceptions.ImagenInexistente.ENCONTRADO_OTRA_IMAGEN;
import static co.com.devco.userinterfaces.PetBookPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FiltrarImagen implements Task {
    private String filtro;

    public FiltrarImagen(String filtro) {
        this.filtro = filtro;
    }

    public static Performable elFiltro(String filtro) {
        return instrumented(FiltrarImagen.class, filtro);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if(filtro.equals("Perro")){
            actor.attemptsTo(
                Click.on(FILTRO_PERRO)
                    //Ensure.that(LISTA_IMAGENES).values().doesNotContain("gato1", "gato2")
                );}
        else if(filtro.equals("Gato")){
            actor.attemptsTo(
                    Click.on(FILTRO_GATO)
                    //Ensure.that(LISTA_IMAGENES).values().doesNotContain("perro1", "perro2", "perro3")
            );}
        else if(filtro.equals("All")){
            actor.attemptsTo(
                     Click.on(FILTRO_ALL)
            );}
        else{
            new FiltroInexistente(FILTRO_NO_EXISTENTE);
        }
        }
    }

