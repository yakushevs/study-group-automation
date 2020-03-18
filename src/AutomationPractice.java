import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPractice {

    public static WebDriver configuracionDriver(String pagina) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,2);
        System.out.println("Ir a la página");
        driver.navigate().to(pagina);
        driver.manage().window().maximize();
        return driver;
    };

   private static class Product {


       //propiedades
        private boolean mouseOverStatus;
        private WebElement btnAddToCart, btnQuickView, btnMore, imgProduct;
        private float value;
        private String productName, productCategory;
        private Object WebDriver;
        private Object Action;
        private WebDriver driver;
        private Actions over;

        public Product (WebDriver driver) {
            this.driver=driver;
            this.over=new Actions(driver);
        }

        //Acciones o metodos
        public  void selectTab(int productIndex) {
            if (productIndex==1) {
                WebElement tabPopular = this.driver.findElement(By.xpath("//*[@class=\"homefeatured\"]"));
                tabPopular.click();
            }
            else {
                WebElement tabBestseller = this.driver.findElement(By.xpath("//*[@class=\"blockbestsellers\"]"));
                tabBestseller.click();
            }

            }

        public WebElement  selectAnyProduct(int productIndex){
            WebElement product= this.driver.findElement(By.xpath("//ul[@id='homefeatured']//li[contains(@class,'ajax_block_product')]"+'['+productIndex+']'));
            over.moveToElement(product).perform();
            //select any product - input Product name & price -- to do

            return product;
        }

        public void addToCart(WebElement product) throws InterruptedException {
            WebElement addToCartButton= product.findElement(By.xpath("div//a[contains(@class,'ajax_add_to_cart_button')]"));
            addToCartButton.click();
            Thread.sleep(5000);

        }

        public void continueShopping() throws InterruptedException {
            WebElement btnContinue = this.driver.findElement(By.xpath("//span[contains(@class,'continue')]"));
            btnContinue.click();
            Thread.sleep(5000);
        }

        public void addToCart_continueShopping() throws InterruptedException {
            this.selectTab(1);
            WebElement product=this.selectAnyProduct(7);
            this.addToCart(product);
            this.continueShopping();
            
        }
   }

    public static void main(String[] args) throws Exception{
        WebDriver driver= configuracionDriver("http://automationpractice.com/index.php?");
        Product product = new Product(driver);
                product.addToCart_continueShopping();

            //add to cart & continue shopping
            // select tab
            // select any product
            // add to cart
            // continue shopping
        //end of add to cart & continue shopping
       /*

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







*/
        driver.close();
    }


}

