package co.com.devco.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PetBookPage {
	public static final String PETBOOK_HOME_PAGE = "http://localhost:4200/";
	public static final Target TITULO_PETBOOK = Target.the("Titulo de la página").located(By.xpath("//div[@class='col-sm-12 btn btn-primary']"));
	public static final Target LISTA_IMAGENES = Target.the("Lista de imagenes de la galeria").located(By.xpath("//div[@class='row']/ul/li"));
	public static final Target IMAGEN_PERRO_1 = Target.the("Imagen perro 2").located(By.xpath("//img[@src='assets/images/perro1.jpg']"));
	public static final Target IMAGEN_PERRO_2 = Target.the("Imagen perro 2").located(By.xpath("//img[@src='assets/images/perro2.jpg']"));
	public static final Target IMAGEN_PERRO_3 = Target.the("Imagen perro 2").located(By.xpath("//img[@src='assets/images/perro3.jpg']"));
	public static final Target IMAGEN_GATO_1 = Target.the("Imagen gato 1").located(By.xpath("//img[@src='assets/images/gato1.jpg']"));
	public static final Target IMAGEN_GATO_2 = Target.the("Imagen gato 2").located(By.xpath("//img[@src='assets/images/gato2.jpeg']"));
	public static final Target IMAGEN_DETALLE = Target.the("Detalle de imagen").located(By.xpath("//app-image-detail//div[@ng-reflect-ng-style='[object Object]']"));
	public static final Target FILTRO_PERRO = Target.the("Filtro Perro").located(By.xpath("//button[contains(text(), 'Perro')]"));
	public static final Target FILTRO_GATO = Target.the("Filtro Gato").located(By.xpath("//button[contains(text(), 'Gato')]"));
	public static final Target FILTRO_ALL = Target.the("Filtro all").located(By.xpath("//button[contains(text(), 'All')]"));

}
