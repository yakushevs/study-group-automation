package com.auto.ui.PageObject;


import org.apache.commons.compress.utils.Lists;
import org.assertj.core.api.SpliteratorAssert;
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
    List <WebElement> VerficationTable;
    Iterator <WebElement> i;

    @FindAll(@FindBy(xpath = "//a[@class='cart_block_product_name']"))
    List <WebElement> itemsOnaList;


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

    public float getTotalInShoppingCart() throws InterruptedException {
        Thread.sleep(1500);
        carritoHeader.click();
            System.out.println("Shopping cart price Method "+carritoTotal.getText().replace("$",""));
        return Float.parseFloat((carritoTotal.getText().replace("$","")));

    }

    public float DropItemfromCart(String vestido) throws InterruptedException {
        carritoHeader.click();
        VerficationTable= driver.findElements(By.xpath("//tr[contains(@class,'cart_item')]"));
        i = VerficationTable.iterator();

            int qty;
            String Units,u;
            float unit_price, total_vestidoBorrado=0;

            while (i.hasNext()){
            WebElement item = i.next();
                if(item.getText().contains(vestido)) {
                    qty= Integer.parseInt(item.findElement(By.xpath(".//td[@class='cart_quantity text-center' ]//input[@type='text']")).getAttribute("value"));
                    u= item.findElement(By.xpath(".//span[contains(@class,'price') and contains(@id,'product_price_')]")).getText().replace("$","");
                    Units=u.substring(0,u.indexOf(" "));
                    System.out.println("Qty: "+qty );
                      unit_price=Float.parseFloat(Units.replace("$","").trim());
                      System.out.println("Precio sin Trans "+ Units);
                      System.out.println("Unit price "+ unit_price);
                      total_vestidoBorrado=qty*unit_price;
                      System.out.println("total eliminate value "+ total_vestidoBorrado);
                      item.findElement(By.xpath(".//i[@class='icon-trash']")).click();
                      SummaryProducts.remove(SummaryProducts.indexOf(vestido));
                    Thread.sleep(1500);
                }


                   }
        System.out.println("Drop item from cart summary products: " + SummaryProducts);
            return total_vestidoBorrado;
        }


    public float DropItemfromlist(String vestido) throws InterruptedException {

        hoverElements(carritoHeader);
        float shippingPrice=0, totalpriceAfterdelete=0;

        for (WebElement item: itemsOnaList){
            System.out.println("item prenda "+ item.getAttribute("title"));

            if(item.getAttribute("title").contains(vestido)){
                item.findElement(By.xpath("./../../..//a[@class='ajax_cart_block_remove_link']")).click();
                SummaryProducts.remove(SummaryProducts.indexOf(vestido));
                Thread.sleep(1500);
                shippingPrice=Float.parseFloat(item.findElement(By.xpath("//span[@class='price cart_block_shipping_cost ajax_cart_shipping_cost']")).getText().replace("$",""));
                totalpriceAfterdelete =Float.parseFloat(item.findElement(By.xpath("//span[@class='price cart_block_total ajax_block_cart_total']")).getText().replace("$",""));
                System.out.println("Total "+ totalpriceAfterdelete);
                System.out.println("Shipping "+ shippingPrice);
                System.out.println("Total deleted without Shipping "+ (totalpriceAfterdelete-shippingPrice));

            }

        }

            System.out.println("Dropitemfrom list summary products: " + SummaryProducts);
        return (totalpriceAfterdelete-shippingPrice);
    }

}


