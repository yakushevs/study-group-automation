import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstClassHelloWold {
    public static void main(String[] args) throws Exception{
        System.out.println("Ziggy!");
        System.out.println("Hi Lucy");
        System.out.println("Morgan Enrique");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
       WebDriver driver=new ChromeDriver();
       driver.navigate().to("https://www.amazon.com/");
        driver.manage().window().maximize();
        WebElement search= driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("power bank");
        WebElement searchIcon=driver.findElement((By.className("nav-input")));
       searchIcon.click();
       //WebElement product= driver.findElement(By.xpath("(//div[@class='sg-col-inner']//img[contains(@data-image-latency,'s-product-image')])[2]"));
       WebElement product= driver.findElement(By.xpath("(//div[@class='s-include-content-margin s-border-bottom']//img)[2]"));
       product.click();
       WebElement addToCartButton= driver.findElement(By.id("add-to-cart-button"));
       addToCartButton.click();
       WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MICROSECONDS);
       driver.close();



    }

}

