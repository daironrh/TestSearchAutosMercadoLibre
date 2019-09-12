import framework.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import po.ResultadosBusqueda;

public class TestAutosMercadoLibre extends BaseTest {

    private ResultadosBusqueda busqueda;

    @Test
    public void searchCars() throws Exception {
        busqueda = inicio.busquedaArticulos("autos");
        int resultadosBusqueda = busqueda.guardarArchivoAnuncios();
        Assert.assertTrue(resultadosBusqueda > 0);
    }


}
