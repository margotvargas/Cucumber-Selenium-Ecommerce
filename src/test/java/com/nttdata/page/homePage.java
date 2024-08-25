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

    //localizadores del carrito

    public static By seleccionProducto = By.xpath("//img[@alt='Hummingbird printed t-shirt']");// Selector para el enlace del primer producto
    public static By cantidadInput = By.xpath("//input[@id='quantity_wanted']");// Selector para añadir la cantidad
    public static By botonAñadirCarrito = By.xpath("//button[@class='btn btn-primary add-to-cart']"); // Selector para el botón de añadir al carrito
    public static By PopupSelector = By.xpath("/html/body/div[1]/div/div/div[2]");//selector del popup
    public static By montoTotalPopup = By.xpath("//span[@class='value'][normalize-space()='229,44 PEN']"); //selector del monto a pagar del popup
    public static By botonFinalizarCompraPopup = By.cssSelector("div[class='cart-content-btn'] a[class='btn btn-primary']");
    public static By tituloCarrito = By.xpath("//h1[contains(text(),'Carrito')]");
    public static By montoTotalCarrito = By.xpath("//span[contains(text(),'229,44')]");

}
