package com.nttdata.steps;
import com.nttdata.page.carritoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class carritoSteps {
    private WebDriver driver;

    //constructor
    public carritoSteps(WebDriver driver){
        this.driver = driver;
    }

    // Método para agregar el producto al carrito
    public void agregarProductoCarrito() {
        driver.findElement(carritoPage.botonAñadirCarrito).click();
    }

    // Validar si el popup de confirmación del producto agregado se muestra
    public boolean muestraPopupProductoAgregado(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement validoPopUp = wait.until(ExpectedConditions.visibilityOfElementLocated(carritoPage.PopupSelector));
        return validoPopUp.isDisplayed();
    }

    // Obtener el monto total mostrado en el popup de confirmación
    public String obtenerMontoTotalpopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement montoTotal = wait.until(ExpectedConditions.visibilityOfElementLocated(carritoPage.montoTotalPopup));
        String montoTotalFinal = montoTotal.getText();

        // Aqui estamos eliminando los caracteres no deseados como el espacio y la moneda, para poder hacer el assert si no no funciona :(
        montoTotalFinal = montoTotalFinal.replace("\u00A0", "").replace("PEN", "").trim();
        return montoTotalFinal;
    }

    //Hacer clic en el botón de finalizar compra
    public void clickCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement finalizarCompra = wait.until(ExpectedConditions.elementToBeClickable(carritoPage.botonFinalizarCompraPopup));
        finalizarCompra.click();
    }

    //Obtener el título de la página del carrito
    public String obtenerTituloPaginaCarrito(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement titulo = wait.until(ExpectedConditions.visibilityOfElementLocated(carritoPage.tituloCarrito));
        return titulo.getText();
    }

    //Obtener el monto total en el carrito
    public String obtenerMontoTotalPaginaCarrito(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement montoTotalCarrito = wait.until(ExpectedConditions.visibilityOfElementLocated(carritoPage.montoTotalCarrito));
        String montoFinalPaginaCarrito = montoTotalCarrito.getText();

        montoFinalPaginaCarrito = montoFinalPaginaCarrito.replace("\u00A0", "").replace("PEN", "").trim();
        return montoFinalPaginaCarrito;
    }

}
