package com.auto.ui.PageObject;


import org.apache.commons.compress.utils.Lists;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingCart extends PageBase {

    @FindBy(xpath = "//span[@class='ajax_cart_quantity unvisible']")
    WebElement contador;
    @FindBy(xpath = "//a[contains(@title,'View my shopping cart')]")
    WebElement carritoHeader;
    @FindAll
    (@FindBy(xpath = "//a[@class='cart_block_product_name']"))
       List <WebElement> productInCart;
    List <String> prendas = Lists.newArrayList();
    //List <String> prendas= new ArrayList<>();

    public ShoppingCart(WebDriver driver) {
        super(driver);
    }

    public List<String> getsProductsNameInCart()  {

        hoverElements(carritoHeader);
        prendas.clear();
        for (WebElement product: productInCart){
            //System.out.println(product.getAttribute("title"));
            prendas.add(product.getAttribute("title"));

        }
        System.out.println("Prendas: "+ prendas);
        return prendas;

    }

    public int getsNumberOfProducts()  {


        int numberofproducts= Integer.parseInt(contador.getText());
        System.out.println("Numero de productos: "+numberofproducts);

        return numberofproducts;
    }

}
