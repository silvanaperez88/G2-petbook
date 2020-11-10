package co.com.devco.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class GoogleSearchPage {
	public static final String GOOGLE_HOME_PAGE = "https://www.google.com";
	public static final Target CAMPO_BUSQUEDA = Target.the("Campo de busqueda en Google").located(By.xpath("//input[@title='Buscar']"));
}
