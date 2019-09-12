package po;

import framework.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaInicioMercadoLibre extends BasePageObject {

    protected By inputTextBusqueda = By.name("as_word");

    public PaginaInicioMercadoLibre(WebDriver driver) throws Exception {
        super(driver);
        if (!driver.getTitle().equals("Mercado Libre Uruguay")){
            throw new Exception("No es la página Mercado Libre Uruguay.");
        }
    }

    public void escribirTextBusqueda(String texto){ driver.findElement(inputTextBusqueda).sendKeys(texto); }
    public void enviarFormulario(){ driver.findElement(inputTextBusqueda).submit(); }

    public ResultadosBusqueda busquedaArticulos(String busqueda) throws Exception {
        escribirTextBusqueda(busqueda);
        enviarFormulario();
        return new ResultadosBusqueda(driver);
    }
}
