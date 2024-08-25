package com.nttdata.steps;


import com.nttdata.page.homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class homeSteps {

    private WebDriver driver;

    //constructor
    public homeSteps(WebDriver driver){
        this.driver = driver;
    }

    // Método para obtener el nombre de usuario mostrado después del login
    public String obtenerNombreUsuario() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement usuarioElemento = wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.usuarioNombre));
        return usuarioElemento.getText();
    }

    //Navegar a categoría CLOTHES incluyendo el escenario negativo distinto a clothes
    public void navegarCategoria(String category){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            WebElement categoryElement = wait.until(ExpectedConditions.elementToBeClickable(homePage.linkCategoria(category)));
            categoryElement.click();
        } catch (Exception e) {
            // Captura la excepción si la categoría no existe y lanza una excepción personalizada
            throw new RuntimeException("La categoría '" + category + "' no existe.");
        }
    }











    //Navegar a una subcategoría Men
    public void navegarSubCategoria(String subcategory){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement subcategoryElement = wait.until(ExpectedConditions.elementToBeClickable(homePage.linkSubCategoria(subcategory)));
        subcategoryElement.click();
    }

    // Método para hacer clic en el primer producto
    public void clickFirstProduct() {
        driver.findElement(homePage.seleccionProducto).click();
    }

    // Método para seleccionar la cantidad deseada
    public void añadircantidad(String cantidad) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement elementoCantidad = wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.cantidadInput));
        elementoCantidad.clear(); // Limpia el campo de entrada antes de ingresar la cantidad
        elementoCantidad.sendKeys(cantidad); // Ingreso la cantidad deseada
    }

    // Método para agregar el producto al carrito
    public void agregarProductoCarrito() {
        driver.findElement(homePage.botonAñadirCarrito).click();
    }

     // Validar si el popup de confirmación del producto agregado se muestra
    public boolean muestraPopupProductoAgregado(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement validoPopUp = wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.PopupSelector));
        return validoPopUp.isDisplayed();
    }


     // Obtener el monto total mostrado en el popup de confirmación
    public String obtenerMontoTotalpopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement montoTotal = wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.montoTotalPopup));
        String montoTotalFinal = montoTotal.getText();

        // Aqui estamos eliminando los caracteres no deseados como el espacio y la moneda, para poder hacer el assert si no no funciona :(
        montoTotalFinal = montoTotalFinal.replace("\u00A0", "").replace("PEN", "").trim();
        return montoTotalFinal;
    }

     //Hacer clic en el botón de finalizar compra
    public void clickCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement finalizarCompra = wait.until(ExpectedConditions.elementToBeClickable(homePage.botonFinalizarCompraPopup));
        finalizarCompra.click();
    }


     //Obtener el título de la página del carrito
        public String obtenerTituloPaginaCarrito(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement titulo = wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.tituloCarrito));
        return titulo.getText();
    }

     //Obtener el monto total en el carrito
    public String obtenerMontoTotalPaginaCarrito(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement montoTotalCarrito = wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.montoTotalCarrito));
        String montoFinalPaginaCarrito = montoTotalCarrito.getText();

        montoFinalPaginaCarrito = montoFinalPaginaCarrito.replace("\u00A0", "").replace("PEN", "").trim();
        return montoFinalPaginaCarrito;
    }

}
