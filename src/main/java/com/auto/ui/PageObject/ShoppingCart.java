package com.auto.ui.PageObject;


import org.apache.commons.compress.utils.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;



import java.util.*;

public class ShoppingCart extends PageBase {

    @FindBy(xpath = "//span[@class='ajax_cart_quantity unvisible']")
    WebElement contador;
    @FindBy(xpath = "//a[contains(@title,'View my shopping cart')]")
    WebElement carritoHeader;
    @FindBy(xpath = "//td[@id='total_product']")
    WebElement carritoTotal;


    @FindAll
    (@FindBy(xpath = "//a[@class='cart_block_product_name']"))
       List <WebElement> productInCart;
    List <String> prendas = Lists.newArrayList();

    //@FindAll(@FindBy(xpath = "//td[@class='cart_description']"))
    List <WebElement> VerficationTable;
    Iterator <WebElement> i;


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

    public float getTotalInShoppingCart(){

        carritoHeader.click();
            System.out.println("Shopping cart price "+carritoTotal.getText().trim().replace("$",""));
        return Float.parseFloat((carritoTotal.getText().trim().replace("$","")));

    }

    public float DropItemfromCart(String vestido) throws InterruptedException {
        carritoHeader.click();
        VerficationTable= driver.findElements(By.xpath("//tr[contains(@class,'cart_item')]"));
        i = VerficationTable.iterator();
            int r=1;
            int qty;
            String Units;
            float unit_price, total_vestidoBorrado=0;
           // String vestido="Blouse";

            while (i.hasNext()){
            WebElement item = i.next();
                if(item.getText().contains(vestido)) {
                   // System.out.println("El vestido es " + item.getText());
                    qty= Integer.parseInt(item.findElement(By.xpath(".//input[contains(@name,'quantity')]")).getAttribute("value"));
                    System.out.println("Qty: "+qty);
                     Units=item.findElement(By.xpath("//span[contains(@class,'price') and contains(@id,'product_price_"+r+"')]")).getText();
                      unit_price=Float.parseFloat(Units.replace("$","").trim());
                      System.out.println("Precio sin Trans "+ Units);
                      System.out.println("Unit price "+ unit_price);
                      total_vestidoBorrado=qty*unit_price;
                      item.findElement(By.xpath("//a[starts-with(@id,'"+r+"_')]")).click();
                      //item.findElement(By.xpath(".//i[@class='icon-trash']")).click();
                    Thread.sleep(1500);
                }

                r++;
                   }
            return total_vestidoBorrado;
        }

    }


