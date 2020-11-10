package co.com.devco.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Attribute;

import static co.com.devco.userinterfaces.GoogleResultadosPage.PRIMER_RESULTADO;
import static co.com.devco.userinterfaces.PetBookPage.FILTRO_PERRO;

public class Filtro implements Question<Boolean> {
    private final String filtro;

    public Filtro(String filtro){
        this.filtro = filtro;
    }

    public static Filtro es(String filtro){
        return new Filtro(filtro);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String filtroSeleccionado = Attribute.of(FILTRO_PERRO).named("perro").toString();
        return filtroSeleccionado.contains(filtro);
    }
}
