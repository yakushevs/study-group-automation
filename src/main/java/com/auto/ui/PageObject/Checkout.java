package com.auto.ui.PageObject;

import com.google.gson.JsonObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


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


    public Checkout(WebDriver driver) {
        super(driver);


    }


    public void clickCheckoutCartlist(){

        checkoutBtnCart.click();
    }

    public void clickCheckout(){

        checkoutBtn.click();
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
}
