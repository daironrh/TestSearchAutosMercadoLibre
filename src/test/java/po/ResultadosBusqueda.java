package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ResultadosBusqueda {
    protected WebDriver driver;
    protected WebDriverWait espera;
    protected By resultadoBusqueda = By.className("rowItem");
    protected By Form = By.id("searchResults");
    protected By textoAnuncio = By.className("main-title");
    protected By linkAnuncio = By.cssSelector("a.item-link");


    public ResultadosBusqueda(WebDriver driver) throws Exception {
        this.driver = driver;
        espera = new WebDriverWait(driver,10);
        if (!driver.getTitle().equals("Autos y Camionetas en Mercado Libre Uruguay")){
            throw new Exception("No es la página Autos y Camionetas en Mercado Libre Uruguay.");
        }
    }

    public boolean busquedaAutosPresente(){
        List<WebElement> resultado = espera.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Form));
        if (!resultado.isEmpty())
            return true;
        return false;
    }

    public int guardarArchivoAnuncios() throws IOException {
        List<WebElement> listaAnuncios = driver.findElements(resultadoBusqueda);
        if (busquedaAutosPresente() && listaAnuncios.size() > 0) {
            File archivo = new File("Anuncio de Autos.txt");
            FileWriter escribir = new FileWriter(archivo, true);
            for (int i = 0; i < listaAnuncios.size(); i++) {
                String cadenaTexto = listaAnuncios.get(i).findElement(textoAnuncio).getText() + " " +
                                     listaAnuncios.get(i).findElement(linkAnuncio).getAttribute("href")+"\n";
                escribir.write(cadenaTexto);
            }
            return listaAnuncios.size();
        }else return 0;
    }

}
