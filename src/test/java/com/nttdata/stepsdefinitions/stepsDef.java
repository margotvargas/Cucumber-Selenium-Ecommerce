package com.nttdata.stepsdefinitions;
import com.nttdata.steps.homeSteps;
import com.nttdata.steps.loginSteps;
import com.nttdata.steps.carritoSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class stepsDef {
    // Atributos de la clase que representan los componentes del sistema en prueba
    private WebDriver driver; // WebDriver es el objeto que controla el navegador.
    private loginSteps loginSteps; // Objeto de la clase loginSteps que maneja el proceso de login.
    private homeSteps homeSteps;  // Objeto de la clase homeSteps que maneja las acciones en la página de inicio.
    private carritoSteps carritoSteps; // Objeto de la clase carritoSteps que maneja las acciones relacionadas con el carrito de compras.

    // Método que configura la página de inicio de la tienda. Es el punto de partida de las pruebas.
    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver(); // Obtenemos el controlador del navegador (Selenium WebDriver).
        driver.get("https://qalab.bensg.com/store/es/iniciar-sesion"); // Navegamos a la página de inicio de sesión.

        // Inicializamos los objetos de las clases homeSteps, loginSteps y carritoSteps, pasando el driver (navegador) a cada uno.
        homeSteps = new homeSteps(driver);  // Inicializar homeSteps - INSTANCIAR
        loginSteps = new loginSteps(driver);  // Inicializar loginSteps - INSTANCIAR
        carritoSteps = new carritoSteps(driver); // Inicializar carritoSteps - INSTANCIAR
        screenShot();
    }

    // Métodos

    @When("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String username, String password) {
        loginSteps.escribirUsuario(username);
        loginSteps.escribirPassword(password);
        loginSteps.clickLogin();
        screenShot();
    }

    @And("valido que estoy autenticado correctamente")
    public void validoQueEstoyAutenticadoCorrectamente() {
        String nombreUsuario = homeSteps.obtenerNombreUsuario();
        Assertions.assertEquals("Margot Vargas", nombreUsuario, "El usuario no se autenticó correctamente.");
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        homeSteps.navegarCategoria(categoria);
        homeSteps.navegarSubCategoria(subcategoria);
        screenShot();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        homeSteps.seleccionarPrimerProducto(); // Hacer clic en el primer producto
        homeSteps.añadircantidad(cantidad); //Hacer clic en el boton icono de aumentar cantidad
        carritoSteps.agregarProductoCarrito(); // Agregar el producto al carrito
        screenShot();
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        Assertions.assertTrue(carritoSteps.muestraPopupProductoAgregado(), "El popup de confirmación no se mostró.");
        screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        String montoTotal = carritoSteps.obtenerMontoTotalpopup();
        Assertions.assertEquals("38,24", montoTotal, "El monto total no es correcto.");
        screenShot();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        carritoSteps.clickCheckout();
        screenShot();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        Assertions.assertEquals("CARRITO", carritoSteps.obtenerTituloPaginaCarrito(), "El título de la página del carrito no es correcto.");
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        String montoTotalPaginaCarrito = carritoSteps.obtenerMontoTotalPaginaCarrito();
        Assertions.assertEquals("38,24", montoTotalPaginaCarrito, "El monto total en el carrito no es correcto.");
    }

    @Then("debería ver un mensaje de error de autenticacion {string}")
    public void deberiaVerUnMensajeDeErrorDeAutenticacion(String mensajeError) {
        String mensajeActual = loginSteps.obtenerMensajeError();
        Assertions.assertEquals(mensajeError, mensajeActual, "El mensaje de error no es el esperado.");
        screenShot();
    }
}
