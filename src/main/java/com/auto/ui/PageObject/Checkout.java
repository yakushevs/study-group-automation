package com.auto.ui.PageObject;

import apple.laf.JRSUIConstants;
import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Checkout extends ShoppingCart {

    @FindBy(xpath = "//a[@id='button_order_cart']")
    WebElement checkoutBtnCart;
    @FindBy(xpath = "//a[contains(@class,'standard-checkout')]")
    WebElement checkoutBtn;
    @FindBy(xpath = "//ul[@id='address_delivery']//li[contains(@class,'address_firstname')]")
    WebElement lblName;
    @FindBy(xpath = "//ul[@id='address_delivery']//li[contains(@class,'address_address')]")
    WebElement lblAddress;
    @FindBy(xpath = "//ul[@id='address_delivery']//li[contains(@class,'address_city')]")
    WebElement lblcity;
    @FindBy(xpath = "//ul[@id='address_delivery']//li[contains(@class,'address_country')]")
    WebElement lblcountry;
    @FindBy(xpath = "//ul[@id='address_delivery']//li[contains(@class,'address_phone')]")
    WebElement lblphone;
    @FindBy (xpath = "//button[contains(@name,'process') and @type='submit']")
    WebElement btnProceedCheckout;
    @FindBy (xpath = "//input[contains(@id,'delivery_option_')]")
            WebElement radioDeliveryStatus;

    @FindBy (xpath = "//input[@type='checkbox']")
        WebElement checkboxStatus;
    @FindBy (xpath = "//p[@class='fancybox-error']")
        WebElement txtWarning;
    @FindBy( xpath = "//a[@class='fancybox-item fancybox-close']")
            WebElement btnWarningClose;
    @FindBy( xpath = "//span[@id='total_price']")
    WebElement totat_priceChekout;

    @FindBy(xpath = "//a[@class='bankwire']")
    WebElement btnTransferbyWire;

    @FindBy (xpath = "//*[@id='amount']")
    WebElement getFloatprecio;
    @FindBy(xpath="//div[@class='box']")
    WebElement orderReference;
    @FindBy(xpath="//button[@class='button btn btn-default button-medium']")
    WebElement btnconfirmMyOrder;
    @FindBy (xpath = "//a[contains(@class,'button-exclusive')]")
    WebElement btnbacktoOrder;

    @FindAll(@FindBy(xpath="//table[@id='order-list']//tr"))
    List<WebElement> tableOrders;

    String OrderNumberText;


            public Checkout(WebDriver driver) {
        super(driver);


    }

    public void clickCheckoutCartlist(){

        checkoutBtnCart.click();
    }

    public void clickCheckout(Boolean proceed){
        if (!proceed) {
        checkoutBtn.click();}
        else { btnProceedCheckout.click();}
    }



    public JsonObject getDeliveryaddress(){

        JsonObject addressDelivery = new JsonObject();
        addressDelivery.addProperty("Name",lblName.getText());
        addressDelivery.addProperty("Address",lblAddress.getText());
        addressDelivery.addProperty("City",lblcity.getText());
        addressDelivery.addProperty("Country",lblcountry.getText());
        addressDelivery.addProperty("Phone",lblphone.getText());


        return addressDelivery;
    }


    public boolean getDeliveryStatus(){

       return super.getRadiobuttonStatus(radioDeliveryStatus);


    }
    public boolean getTermofServiceStatus(){

        return super.getCheckBoxStatus(checkboxStatus);

    }
    public void setTermofService(){
        if (!getTermofServiceStatus()){
            checkboxStatus.click();
        }
    }

    public String getWarningText(){

        return txtWarning.getText();
    }

    public void  clickclosedwarrning(){
                btnWarningClose.click();
    }

    public float getTotal_price_Checkout(){

        return Float.parseFloat(totat_priceChekout.getText().substring(1,totat_priceChekout.getText().length()));
    }


    public float getTotal_price_confirm(){

        return Float.parseFloat(getFloatprecio.getText().substring(1,getFloatprecio.getText().length()));
    }

    public void clickbtnTransferwire() {

        btnTransferbyWire.click();
    }
    public void clickbtnconfirmorder() {

        btnconfirmMyOrder.click();
    }
    public void clickbtnbacktoOrder(){
        btnbacktoOrder.click();
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
}

