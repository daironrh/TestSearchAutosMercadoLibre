package po;

import framework.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaInicioMercadoLibre extends BasePageObject {

    protected By inputTextBusqueda = By.name("as_word");
    protected By botonBusqueda = By.xpath("/html/body/header/div/form/button/div");

    public PaginaInicioMercadoLibre(WebDriver driver) throws Exception {
        this.driver = driver;
        if (!driver.getTitle().equals("Mercado Libre Uruguay")){
            throw new Exception("No es la página Mercado Libre Uruguay.");
        }
    }

    public void escribirTextBusqueda(String texto){ driver.findElement(inputTextBusqueda).sendKeys(texto); }

    public void clickBotonBuscar(){
        driver.findElement(botonBusqueda).click();
    }

    public ResultadosBusqueda busquedaArticulos(String busqueda) throws Exception {
        escribirTextBusqueda(busqueda);
        clickBotonBuscar();
        return new ResultadosBusqueda(driver);
    }
}
