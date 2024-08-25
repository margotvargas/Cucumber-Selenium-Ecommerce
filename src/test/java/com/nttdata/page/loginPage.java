package com.nttdata.page;

import org.openqa.selenium.By;

public class loginPage {

    //Localizadores de elementos login
    public static By usernameInput = By.id("field-email");
    public static By passwordInput = By.id("field-password");
    public static By loginButton = By.id("submit-login");
    public static By errorMensaje = By.xpath("//li[@class='alert alert-danger']");

}
