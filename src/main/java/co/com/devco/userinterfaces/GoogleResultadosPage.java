package co.com.devco.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class GoogleResultadosPage {
    public static final Target RESULTADOS_BUSQUEDA = Target.the("resultados de bsuqueda").located(By.xpath("//div[@id='search']"));
    public static final Target PRIMER_RESULTADO = Target.the("Primer resultado de busqueda").located(By.xpath("//div[@id='search']//div[@class='g' and position()=1]//link"));
}
