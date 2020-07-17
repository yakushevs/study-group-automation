package com.auto.ui.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkout extends ShoppingCart {

    @FindBy(xpath = "//a[@id='button_order_cart']")
    WebElement checkoutBtnCart;
    @FindBy(xpath = "//a[contains(@class,'standard-checkout')]")
    WebElement checkoutBtn;


    public Checkout(WebDriver driver) {
        super(driver);
    }


    public void clickCheckoutCartlist(){

        checkoutBtnCart.click();
    }

    public void clickCheckout(){

        checkoutBtn.click();
    }
}
