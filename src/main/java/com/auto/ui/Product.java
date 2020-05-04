package com.auto.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class Product {


        //Properties
        private int productIndex;
        private String tabName;
        private WebDriver driver;
        private Actions over;

        //Elements
    @FindBy(xpath ="//*[@class=\"homefeatured\"]" )
    WebElement tabPopular;
    @FindBy(xpath = "//*[@class=\"blockbestsellers\"]")
    WebElement tabBestseller;
    @FindBy(xpath = "//span[contains(@class,'continue')]")
    WebElement btnContinue;
    @FindAll(@FindBy(xpath="//ul[@id='homefeatured']//li[contains(@class,'ajax_block_product')]"))
    List<WebElement> productsPopular;
    @FindAll(@FindBy(xpath="//ul[@id='blockbestsellers']//li[contains(@class,'ajax_block_product')]"))
    List<WebElement> productBestSeller;



        public Product (WebDriver driver) {
            this.driver=driver;
            over=new Actions(driver);
        }
        public Product(WebDriver driver,String tabName,int productIndex){
            this.driver=driver;
            over=new Actions(driver);
            this.tabName=tabName;
            this.productIndex=productIndex;
        }

        //Methods or Actions
        public  void selectTab(String tabName) {
            if (tabName=="popular") {
                //WebElement tabPopular = driver.findElement(By.xpath("//*[@class=\"homefeatured\"]"));
                tabPopular.click();
            }
            else {
               // WebElement tabBestseller = driver.findElement(By.xpath("//*[@class=\"blockbestsellers\"]"));
                tabBestseller.click();
            }

        }

        public WebElement  selectAnyProduct(String tabName,int productIndex){

            WebElement product;
            if (tabName=="popular"){
                product= productsPopular.get(productIndex);

                //select any product - input Product name & price -- to do

            }else {

                product= productBestSeller.get(productIndex);



            }
            over.moveToElement(product).perform();

            return product;
        }

        public void addToCart(WebElement product) throws InterruptedException {


            WebElement addToCartButton= product.findElement(By.xpath("div//a[contains(@class,'ajax_add_to_cart_button')]"));
            addToCartButton.click();
            Thread.sleep(5000);

        }

        public void continueShopping() throws InterruptedException {

            btnContinue.click();
            Thread.sleep(5000);
        }

        public void addToCart_continueShopping(String tabName,int productIndex) throws InterruptedException {

            selectTab(tabName);
            WebElement product=selectAnyProduct(tabName,productIndex);
            addToCart(product);
            continueShopping();

        }







    }



