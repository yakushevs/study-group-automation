package com.auto.ui.PageObject;

import com.sun.tools.internal.xjc.model.CElement;
import org.apache.commons.compress.utils.Lists;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import sun.awt.image.SurfaceManager;

import java.util.List;

public class PageBase {


    public Actions over;
    public WebDriver driver;
    public static List<String> SummaryProducts = Lists.newArrayList();


    public PageBase(WebDriver driver){

        this.driver=driver;
        this.over= new Actions(this.driver);
    }

    public void hoverElements(WebElement element){



        over.moveToElement(element).perform();


    }

    public boolean getRadiobuttonStatus(WebElement element){

        return element.isEnabled();
    }
    public boolean getCheckBoxStatus(WebElement element){

        return element.isSelected();

    }


}

