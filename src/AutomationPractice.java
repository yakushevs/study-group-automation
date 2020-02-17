import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import static org.openqa.selenium.WebDriver.*;

public class AutomationPractice {
    public static void main(String[] args) throws Exception{

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,2);
        System.out.println("Ir a la pagina");
        driver.navigate().to("http://automationpractice.com/index.php?");
        driver.manage().window().maximize();

        JavascriptExecutor js= (JavascriptExecutor) driver;
        System.out.println("Scroll down");
        js.executeScript("window.scrollTo(0,1200)");

        WebElement product= driver.findElement(By.xpath("//ul[@id='homefeatured']//li[contains(@class,'ajax_block_product')][7]"));
        Actions over=new Actions(driver);
        over.moveToElement(product).perform();

        WebElement addbutton= product.findElement(By.xpath("div//a[contains(@class,'ajax_add_to_cart_button')]"));

    System.out.println("Click");
        addbutton.click();
        Thread.sleep(5000);
        System.out.println("Esperar");



            driver.close();



    }


}

