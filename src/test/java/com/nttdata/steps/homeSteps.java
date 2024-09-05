package com.nttdata.steps;

import com.nttdata.page.homePage;
import com.nttdata.page.carritoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static com.nttdata.page.carritoPage.botonaumentarcantidad;

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
    public void seleccionarPrimerProducto() {
        driver.findElement(carritoPage.seleccionProducto).click();
    }

    /*/ Método para seleccionar la cantidad deseada Fallo pero se deja como referencia
    public void añadircantidad(String cantidad) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement elementoCantidad = wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.cantidadInput));
        elementoCantidad.clear(); // Limpia el campo de entrada antes de ingresar la cantidad
        elementoCantidad.sendKeys(cantidad); // Ingreso la cantidad deseada
    }*/

    public void añadircantidad(int cantidad) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(botonaumentarcantidad));

        for (int i = 1; i < cantidad; i++) {
            driver.findElement(botonaumentarcantidad).click();
        }
    }


}
