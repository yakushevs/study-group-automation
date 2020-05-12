package com.auto.ui.PageObject;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart extends PageBase {

    @FindBy(xpath = "//span[@class='ajax_cart_quantity unvisible']")
    WebElement contador;

    public int getsNumberOfProducts()  {


        int numberofproducts= Integer.parseInt(contador.getText());
        System.out.println("Numero de productos: "+numberofproducts);

        return numberofproducts;
    }

}
