package com.nttdata.steps;

import com.nttdata.page.loginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class loginSteps {

    private WebDriver driver;

    //constructor
    public loginSteps(WebDriver driver){
        this.driver = driver;
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
        this.driver.findElement(loginPage.passwordInput).sendKeys(password);
    }

    // Metodo para hacer click en el botón login
    public void clickLogin() {
        this.driver.findElement(loginPage.loginButton).click();
    }

    public String obtenerMensajeError() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement mensajeErrorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.errorMensaje));
        return mensajeErrorElement.getText();
    }

}
