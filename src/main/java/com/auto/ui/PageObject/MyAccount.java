package com.auto.ui.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MyAccount extends PageBase {

    @FindBy(xpath="//div[@class='box']")
    WebElement orderReference;
    @FindAll(@FindBy(xpath="//table[@id='order-list']//tr"))
    List<WebElement> tableOrders;
    @FindBy (xpath = "//a[contains(@class,'button-exclusive')]")
    WebElement btnbacktoOrder;
    float priceMyaccount;
    String OrderNumberText;



    public MyAccount(WebDriver driver) {
        super(driver);
    }


    public String getreferenceorder(){
        Pattern pattern = Pattern.compile("([A-Z]{9})");
        Matcher matcher = pattern.matcher(orderReference.getText());
        matcher.find();
        String  orderReferenceText=  matcher.group(1);
        System.out.println("Order Reference " + orderReferenceText);

        return orderReferenceText;


    }

    public String validateOrderReference(String OrderReference){

        for (WebElement OrderRow: tableOrders){
            OrderNumberText=OrderRow.findElement(By.xpath("//a[@class='color-myaccount']")).getText();
            if (OrderNumberText.contains(OrderReference)){
                System.out.println("The order is " + OrderNumberText);

                break;
            }

        }
        return OrderNumberText;
    }
    public float validateOrderPrice(String OrderReference){

        for (WebElement OrderRow: tableOrders){
            OrderNumberText=OrderRow.findElement(By.xpath("//a[@class='color-myaccount']")).getText();
            if (OrderNumberText.contains(OrderReference)){

                priceMyaccount= Float.parseFloat(OrderRow.findElement(By.xpath("//td[@class='history_price']")).getText().replace("$",""));

                break;
            }

        }
        return priceMyaccount;
    }





    public void clickbtnbacktoOrder(){
        btnbacktoOrder.click();
    }

}
