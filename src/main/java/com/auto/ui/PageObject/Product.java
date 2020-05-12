package com.auto.ui.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


import java.util.List;


public class Product extends PageBase {


        //Properties

        private WebDriver driver;
        private Actions over;
        //= new Actions(driver);
        private WebElement product;
        //Elements
    @FindBy(xpath ="//*[@class='homefeatured']" )
    WebElement tabPopular;
    @FindBy(xpath = "//*[@class='blockbestsellers']")
    WebElement tabBestseller;
    @FindBy(xpath = "//span[contains(@class,'continue')]")
    WebElement btnContinue;
    @FindAll(@FindBy(xpath="//ul[@id='homefeatured']//li[contains(@class,'ajax_block_product')]"))
    List<WebElement> productsPopular;
    @FindAll(@FindBy(xpath="//ul[@id='blockbestsellers']//li[contains(@class,'ajax_block_product')]"))
    List<WebElement> productBestSeller;



        public Product (WebDriver driver) {
            this.driver=driver;
            this.over= new Actions(this.driver);
        }


        //Methods or Actions
        public  void selectTab(String tabName) {
            if (tabName=="popular") {

                tabPopular.click();
            }
            else {

                tabBestseller.click();
            }

        }
    public WebElement  selectAnyProduct(String tabName,String productName)  {

        if (tabName=="popular"){

            for (WebElement popular : productsPopular){

                if(popular.getText().contains(productName)){
                    product=popular;
                    break;
                }
            }

        }else {
            for (WebElement bestseller : productBestSeller){
                if(bestseller.getText().contains(productName)){
                    product=bestseller;
                    break;
                }
            }
        }

        over.moveToElement(product).perform();
        return product;
    }


    public WebElement  selectAnyProduct(String tabName,int productIndex){

            if (tabName=="popular"){
                product= productsPopular.get(productIndex);
            }else {
                product= productBestSeller.get(productIndex);
            }

            over.moveToElement(product).perform();

            return product;
        }



    public void addToCart(WebElement product) throws InterruptedException {


            WebElement addToCartButton= product.findElement(By.xpath("div//a[contains(@class,'ajax_add_to_cart_button')]"));
            addToCartButton.click();
            Thread.sleep(1500);

        }

        public void continueShopping() throws InterruptedException {

            btnContinue.click();
            Thread.sleep(1500);
        }
    public void addToCart_continueShopping(String tabName,String productName) throws InterruptedException {

        selectTab(tabName);
        WebElement product=selectAnyProduct(tabName,productName);
        addToCart(product);
        continueShopping();
    }

        public void addToCart_continueShopping(String tabName,int productIndex) throws InterruptedException {

            selectTab(tabName);
            WebElement product=selectAnyProduct(tabName,productIndex);
            addToCart(product);
            continueShopping();

        }

}
