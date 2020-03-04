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
    public static WebDriver configuracionDriver(String pagina) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,2);
        System.out.println("Ir a la página");
        driver.navigate().to(pagina);
        driver.manage().window().maximize();
        return driver;
    };
    public static void main(String[] args) throws Exception{

        WebDriver driver= configuracionDriver("http://automationpractice.com/index.php?");
        /*
        JavascriptExecutor js= (JavascriptExecutor) driver;
        System.out.println("Adicionar producto popular");
        js.executeScript("window.scrollTo(0,1200)");

        WebElement product= driver.findElement(By.xpath("//ul[@id='homefeatured']//li[contains(@class,'ajax_block_product')][7]"));
        Actions over=new Actions(driver);
        over.moveToElement(product).perform();

        WebElement addbutton= product.findElement(By.xpath("div//a[contains(@class,'ajax_add_to_cart_button')]"));


    System.out.println("Producto popular adicionado");
        addbutton.click();
        Thread.sleep(5000);
        WebElement btnContinue = driver.findElement(By.xpath("//span[contains(@class,'continue')]"));
        btnContinue.click();
        System.out.println("continue shopping");

//--------
        System.out.println("Seleccionar Best Sellers");
        Thread.sleep(5000);
        WebElement tabBestseller=driver.findElement(By.xpath("//*[@id=\"home-page-tabs\"]/li[2]/a"));

        tabBestseller.click();
        System.out.println("Seleccionar producto");
        WebElement productBeste= driver.findElement(By.xpath("//ul[@id='blockbestsellers']//li[contains(@class,'ajax_block_product')][4]"));
        over.moveToElement(productBeste).perform();
        Thread.sleep(5000);

        WebElement btnAddBestie = productBeste.findElement(By.xpath("div//a[contains(@class,'ajax_add_to_cart_button')]"));
        btnAddBestie.click();
        Thread.sleep(5000);
        System.out.println("Producto Best Seller adicionado");


        Thread.sleep(5000);
        WebElement btnContinueBestie = productBeste.findElement(By.xpath("//span[contains(@class,'continue')]"));
        btnContinueBestie.click();
        Thread.sleep(5000);
        System.out.println("continue shopping on best selling");

////ul[@id='blockbestsellers']//li[contains(@class,'ajax_block_product')][5]/div//a[contains(@class,'ajax_add_to_cart')]

//--- Segundo producto de best seller
        System.out.println("Seleccionar producto");
        productBeste= driver.findElement(By.xpath("//ul[@id='blockbestsellers']//li[contains(@class,'ajax_block_product')][6]"));
        over.moveToElement(productBeste).perform();
        Thread.sleep(5000);

        btnAddBestie = productBeste.findElement(By.xpath("div//a[contains(@class,'ajax_add_to_cart_button')]"));
        btnAddBestie.click();
        Thread.sleep(5000);
        System.out.println("Producto Best Seller adicionado");


        Thread.sleep(5000);
        btnContinueBestie = productBeste.findElement(By.xpath("//span[contains(@class,'continue')]"));
        btnContinueBestie.click();
        Thread.sleep(5000);
        System.out.println("continue shopping on best selling");





        //driver.close();

*/

    }


}

