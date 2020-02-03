import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class AutomationPractice {
    public static void main(String[] args) throws Exception{

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("http://automationpractice.com/index.php?");
        driver.manage().window().maximize();
        WebElement product= driver.findElement(By.xpath("//ul[@id='homefeatured']//div[@class='product-container'][1]"));
        Actions over=new Actions(driver);
        over.moveToElement(product).perform();
        By locator = By.xpath("//a[@title='Add to cart']");
        driver.click(locator);




//        WebElement we= WebDriver.findElement(By.xpath("//a[@title='Add to cart']")).click().build().perform();
        //product.click();


       /* Actions builder = new Actions(driver);
builder.moveToElement(hoverElement).perform();
By locator = By.id("clickElementID");
driver.click(locator);

       Actions builder = new Actions(driver);
builder.moveToElement(hoverElement).perform();
builder.moveToElement(clickElement).click().perform();


       Actions action = new Actions(webdriver);
        WebElement we = webdriver.findElement(By.xpath("html/body/div[13]/ul/li[4]/a"));
        action.moveToElement(we).moveToElement(webdriver.findElement(By.xpath("/expression-here"))).click().build().perform();


        product.over
    //a[@title='Add to cart']
        product.click();
        WebElement addToCartButton= driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MICROSECONDS);
        driver.close();*/



    }


}

