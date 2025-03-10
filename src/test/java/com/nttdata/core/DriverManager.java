package com.nttdata.core;

import io.cucumber.java.After; // Importamos la anotación @After de Cucumber para ejecutar código al final de un escenario.
import io.cucumber.java.Before; // Importamos la anotación @Before de Cucumber para ejecutar código antes de cada escenario.
import io.cucumber.java.Scenario; // Importamos la clase Scenario de Cucumber, que permite manejar información de los escenarios en ejecución.
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot; // Interface de Selenium que permite tomar capturas de pantalla.
import org.openqa.selenium.WebDriver; // Importamos la interfaz WebDriver para controlar el navegador.
import org.openqa.selenium.chrome.ChromeDriver; // Importamos la clase ChromeDriver para manejar el navegador Google Chrome.

public class DriverManager {
    private static WebDriver driver;
    private static Scenario scenario;

    public static WebDriver getDriver(){
        return driver;
    }

    @Before(order = 0)
    public void setUp(){
        //Se ejecutará Automáticamente
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

    public static void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(evidencia, "image/png", "evidencias");
    }
}
