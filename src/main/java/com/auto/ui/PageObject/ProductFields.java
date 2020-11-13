package com.auto.ui.PageObject;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class ProductFields extends PageBase{

    @FindBy(xpath="//div[@id='block_top_menu']/ul/li/a[@title='Dresses']")

    WebElement Dresses;
    WebElement product,More;
    JSONObject productDetails;

    @FindBy(xpath = "//h1[@itemprop='name']")
       WebElement   title;
    @FindBy (xpath = "//p[@id='product_condition']/span")
    WebElement condition;
    @FindBy (xpath = "//*[@id='short_description_content']")
    WebElement shortdesc;
    @FindBy(xpath = "//*[contains(@class,'btn-twitter')]")
    WebElement btnTwitter;
    @FindBy(xpath = "//*[contains(@class,'btn-facebook')]")
    WebElement btnFacebook;

    @FindBy(xpath = "//*[contains(@class,'btn-google-plus')]")
    WebElement btnGoogle;

    @FindBy(xpath = "//*[contains(@class,'btn-pinterest')]")
    WebElement btnPinterest;

    @FindAll(@FindBy(xpath ="//ul[@class='product_list grid row']/li"))
    List<WebElement> productsTypeDresses;



    public ProductFields(WebDriver driver) {
        super(driver);
    }

        public void ClickproductDresses() throws InterruptedException {

            Dresses.click();
            Thread.sleep(1500);

        }



    public void SelectDress  (int productIndex){

        System.out.println("la prenda es "+ productsTypeDresses.size());

            product= productsTypeDresses.get(productIndex);

        hoverElements(product);
        More=product.findElement(By.xpath(".//a[@title='View']"));
        More.click();

    }

    public String getTitle() {

        try {
            title.isDisplayed();
            return title.getText();
        } catch (Exception e) {

            return e.getMessage();
        }

    }
    public String getCondition(){

        try{
            condition.isDisplayed();
            return condition.getText();

        }catch (Exception e){
            return e.getMessage();
        }
    }
    public String getShortdesc(){

        try{
            shortdesc.isDisplayed();
            return shortdesc.getText();

        }catch (Exception e){
            return e.getMessage();
        }
    }
    public void clickBtnTwitter(){

        try{
            btnTwitter.isEnabled();
             btnTwitter.click();

        }catch (Exception e){
             e.getMessage();
        }
    }


    //=======
    public JSONObject selectProduct(int productIndex) throws InterruptedException{
        product = productsTypeDresses.get(productIndex);
        String productTitle=getTitleProduct(product);
        super.hoverElements(product);
        Thread.sleep(2000);
        Float productPrice=getPriceProduct(product);
        boolean productAddToCompare= getAddToCompareProduct(product);
        boolean productWishList= getWishListProduct(product);
        System.out.println("productTitle " + productTitle +" and productPrice" + productPrice );
        Thread.sleep(1000);
        WebElement moreButton= product.findElement(By.xpath(".//a[@title='View']"));
        Thread.sleep(2000);
        moreButton.click();
        Thread.sleep(2000);
        productDetails = new JSONObject();
        productDetails.put("Index" , productIndex);
        productDetails.put("Title" , productTitle);
        productDetails.put("Price", productPrice);
        productDetails.put("Compare", productAddToCompare);
        productDetails.put("WishList", productWishList);
        return productDetails;
    }


    public String getTitleProduct(WebElement product) throws InterruptedException {
        String productTitle = product.findElement(By.xpath(".//a[@class='product_img_link']")).getAttribute("title");
        return productTitle;
    }
    public Float getPriceProduct(WebElement product) throws InterruptedException {
        float productPrice = Float.parseFloat(product.findElement(By.xpath(".//div[@class='content_price']//span")).getText().replace("$",""));
        return productPrice;
    }
    public Boolean getAddToCompareProduct(WebElement product) throws InterruptedException {
        boolean AddToCompareProduct = product.findElement(By.xpath(".//a[@class='add_to_compare']")).isDisplayed();
        return AddToCompareProduct;
    }
    public Boolean getWishListProduct(WebElement product) throws InterruptedException {
        boolean AddToCompareProduct = product.findElement(By.xpath(".//div[@class='wishlist']")).isDisplayed();
        return AddToCompareProduct;
    }


}



