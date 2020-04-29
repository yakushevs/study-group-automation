package com.auto.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;



public class OpenGoogle {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().version("80.0.3987.106").setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");
        Product homepage = PageFactory.initElements(driver,Product.class);
        homepage.addToCart_continueShopping("popular",4);



        driver.close();

    }
}
