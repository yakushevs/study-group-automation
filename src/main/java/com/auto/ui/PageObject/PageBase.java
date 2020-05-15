package com.auto.ui.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageBase {


    public Actions over;
    public WebDriver driver;


    public PageBase(WebDriver driver){

        this.driver=driver;
        this.over= new Actions(this.driver);
    }

    public void hoverElements(WebElement element){



        over.moveToElement(element).perform();


    }


}
