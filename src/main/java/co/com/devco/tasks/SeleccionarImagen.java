package co.com.devco.tasks;

import co.com.devco.exceptions.ImagenInexistente;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ensure.web.ElementsLocated;

import java.util.NoSuchElementException;

import static co.com.devco.exceptions.ImagenInexistente.ENCONTRADO_OTRA_IMAGEN;
import static co.com.devco.userinterfaces.PetBookPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarImagen implements Task {
    private String img;

    public SeleccionarImagen(String img) {
        this.img = img;
    }

    public static Performable seleccionarImagen(String img) {
        return instrumented(SeleccionarImagen.class, img);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
         if(img.equals("perro")) {
            actor.attemptsTo(
                Click.on(IMAGEN_PERRO_2),
                Ensure.that(IMAGEN_DETALLE).containsElements("//div[@class='img-container']"));
        }else if(img.equals("gato")){
            actor.attemptsTo(
                    Click.on(IMAGEN_GATO_1),
                    Ensure.that(IMAGEN_DETALLE).containsElements("//div[@class='img-container']"));
        }else{
            new ImagenInexistente(ENCONTRADO_OTRA_IMAGEN);
        }


    }
}
