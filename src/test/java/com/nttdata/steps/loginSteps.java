package com.nttdata.steps;

import com.nttdata.page.loginPage;// Importamos la clase loginPage, que contiene los localizadores de los elementos de la página de inicio de sesión.
import org.openqa.selenium.WebDriver; // Importamos la interfaz WebDriver, que es utilizada para interactuar con el navegador.
import org.openqa.selenium.WebElement; // Importamos la clase WebElement, que representa un elemento en la página web.
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class loginSteps {

    // Atributo que contiene la instancia de WebDriver. Esto permite interactuar con el navegador en el contexto de la clase.
    private WebDriver driver;

    // Constructor de la clase loginSteps.
    // Aquí pasamos el WebDriver desde la clase que llama (en este caso, desde stepsDef) para que sea utilizado en todos los métodos de esta clase.
    public loginSteps(WebDriver driver){
        this.driver = driver; // Asignamos el driver pasado al atributo driver de la clase.
    }

    //Metodo para escribir el usuario
    public void escribirUsuario(String user) {
        // Especificar la espera explícita para el campo de usuario
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        // Esperar hasta que el elemento del campo de usuario esté visible
        WebElement userInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.usernameInput));
        // Ingresar el usuario
        userInputElement.sendKeys(user);
        // Opcional: Esperar hasta que el botón de login sea visible antes de continuar
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.loginButton));
    }

     //Metodo para escribir el password
    public void escribirPassword(String password) {
        // Encontramos el campo de la contraseña y le enviamos el texto (password).
        this.driver.findElement(loginPage.passwordInput).sendKeys(password);
    }

    // Metodo para hacer click en el botón login
    public void clickLogin() {
        // Encontramos el botón de login y hacemos clic en él.
        this.driver.findElement(loginPage.loginButton).click();
    }

    public String obtenerMensajeError() {
        // Definimos una espera explícita de 20 segundos para el mensaje de error.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Esperamos hasta que el elemento que contiene el mensaje de error sea visible.
        WebElement mensajeErrorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.errorMensaje));

        // Devolvemos el texto del mensaje de error para validarlo en las pruebas.
        return mensajeErrorElement.getText();
    }
}
