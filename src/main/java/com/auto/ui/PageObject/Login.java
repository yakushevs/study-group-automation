package com.auto.ui.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Login extends PageBase{

    @FindBy (xpath ="//input[@id='email']" )
    WebElement email;
    @FindBy (xpath ="//input[@id='passwd']" )
    WebElement pwd;

    @FindBy (xpath = "//button[@id='SubmitLogin']")
    WebElement btnSubmit;
    @FindBy (xpath = "//a[@class='logout']")
    WebElement btnLogout;

    public Login(WebDriver driver) {
        super(driver);
    }

public void login (String email, String pwd){


        this.email.clear();
        this.email.sendKeys(email);
        this.pwd.clear();
        this.pwd.sendKeys(pwd);
        btnSubmit.click();


}

public void logout(){

        btnLogout.click();

}



}



