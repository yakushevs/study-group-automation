import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Currency;
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

   private class Product {

        //propiedades
        private boolean mouseOverStatus;
        private WebElement btnAddToCart, btnQuickView, btnMore, imgProduct;
        private float value;
        private String productName, productCategory;

        public Product () {
        }

        //Acciones o metodos
        public static selectTab(int productIndex) {
            WebElement tabPopular=driver.findElement(By.xpath("//*[@class=\"homefeatured\"]"));
            tabPopular.click();

        }

        public static addProduct(int productIndex){
        }
   }

    public static void main(String[] args) throws Exception{

        WebDriver driver= configuracionDriver("http://automationpractice.com/index.php?");

        Actions over=new Actions(driver);
        //select tab - variable entrada xpath

        //fin metodo select
        //select any product - input variable product index
        //select any product - input Product name & price
        WebElement product= driver.findElement(By.xpath("//ul[@id='homefeatured']//li[contains(@class,'ajax_block_product')][7]"));
        over.moveToElement(product).perform();
        // end of select any product
        // add to cart
        WebElement addToCartButton= product.findElement(By.xpath("div//a[contains(@class,'ajax_add_to_cart_button')]"));
        addToCartButton.click();
        Thread.sleep(5000);
        // end of add to cart
        //continue shopping
        WebElement btnContinue = driver.findElement(By.xpath("//span[contains(@class,'continue')]"));
        btnContinue.click();
        Thread.sleep(5000);
        //end of continue shopping
        //add to cart & continue shopping
            // select tab
            // select any product
            // add to cart
            // continue shopping
        //end of add to cart & continue shopping
        WebElement tabBestseller=driver.findElement(By.xpath("//*[@class=\"blockbestsellers\"]"));
        tabBestseller.click();
        WebElement productBeste= driver.findElement(By.xpath("//ul[@id='blockbestsellers']//li[contains(@class,'ajax_block_product')][4]"));
        over.moveToElement(productBeste).perform();
        WebElement btnAddBestie = productBeste.findElement(By.xpath("div//a[contains(@class,'ajax_add_to_cart_button')]"));
        btnAddBestie.click();
        Thread.sleep(5000);
        WebElement btnContinueBestie = productBeste.findElement(By.xpath("//span[contains(@class,'continue')]"));
        btnContinueBestie.click();
        Thread.sleep(5000);


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

