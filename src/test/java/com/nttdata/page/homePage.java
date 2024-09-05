package com.nttdata.page;
import org.openqa.selenium.By;

public class homePage {
    // Selector para el nombre de usuario después del inicio de sesión
    public static By usuarioNombre = By.xpath("//span[contains(text(),'Margot Vargas')]");

    //localizadores del home
    public static By linkCategoria(String categoria) {
        return By.linkText(categoria);//usamos como localizador el LINKTEXT ya que es el mas adecuado en este caso
    }
    public static By linkSubCategoria(String subcategoria) {
        return By.linkText(subcategoria);
    }

}
