package com.nttdata.stepsdefinitions;
import com.nttdata.steps.homeSteps;
import com.nttdata.steps.loginSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;


import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class loginStepsDef {

    private WebDriver driver;
    private homeSteps homeSteps;  // Declaración de homeSteps como variable de instancia
    private loginSteps loginSteps; // Declaración de loginSteps como variable de instancia

    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/es/iniciar-sesion");

        homeSteps = new homeSteps(driver);  // Inicializar homeSteps
        loginSteps = new loginSteps(driver);  // Inicializar loginSteps

        screenShot();
    }

    @When("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String username, String password) {
        loginSteps = new loginSteps(driver);  // Instanciación de loginSteps
        loginSteps.escribirUsuario(username);
        loginSteps.escribirPassword(password);
        loginSteps.clickLogin();
        screenShot();
    }

    @And("valido que estoy autenticado correctamente")
    public void validoQueEstoyAutenticadoCorrectamente() {
        //homeSteps homeSteps = getHomeSteps(driver);
        String nombreUsuario = homeSteps.obtenerNombreUsuario();
        Assertions.assertEquals("Margot Vargas", nombreUsuario, "El usuario no se autenticó correctamente.");
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        homeSteps = new homeSteps(driver);  // Instanciación de homeSteps
        homeSteps.navegarCategoria(categoria);
        homeSteps.navegarSubCategoria(subcategoria);
        screenShot();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        homeSteps.clickFirstProduct(); // Hacer clic en el primer producto
        homeSteps.añadircantidad(String.valueOf(cantidad)); // Seleccionar la cantidad deseada
        homeSteps.agregarProductoCarrito(); // Agregar el producto al carrito
        screenShot();
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        Assertions.assertTrue(homeSteps.muestraPopupProductoAgregado(), "El popup de confirmación no se mostró.");
        screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        String montoTotal = homeSteps.obtenerMontoTotalpopup();
        Assertions.assertEquals("229,44", montoTotal, "El monto total no es correcto.");
        screenShot();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        homeSteps.clickCheckout();
        screenShot();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        Assertions.assertEquals("CARRITO", homeSteps.obtenerTituloPaginaCarrito(), "El título de la página del carrito no es correcto.");
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        String montoTotalPaginaCarrito = homeSteps.obtenerMontoTotalPaginaCarrito();
        Assertions.assertEquals("229,44", montoTotalPaginaCarrito, "El monto total en el carrito no es correcto.");
    }

    @Then("debería ver un mensaje de error de autenticacion {string}")
    public void deberiaVerUnMensajeDeErrorDeAutenticacion(String mensajeError) {
        String mensajeActual = loginSteps.obtenerMensajeError();
        Assertions.assertEquals(mensajeError, mensajeActual, "El mensaje de error no es el esperado.");
        screenShot();
    }

}
