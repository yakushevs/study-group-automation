import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPractice {

    public static WebDriver configuracionDriver(String page) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,2);
        System.out.println("Ir a la página");
        driver.navigate().to(page);
        driver.manage().window().maximize();
        return driver;
    };

   private static class Product {


       //Properties
        private int productIndex;
        private String tabName;
        private WebDriver driver;
        private Actions over;

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
                WebElement tabPopular = driver.findElement(By.xpath("//*[@class=\"homefeatured\"]"));
                tabPopular.click();
            }
            else {
                WebElement tabBestseller = driver.findElement(By.xpath("//*[@class=\"blockbestsellers\"]"));
                tabBestseller.click();
            }

        }

        public WebElement  selectAnyProduct(String tabName,int productIndex){

            WebElement product;
            if (tabName=="popular"){
             product= driver.findElement(By.xpath("//ul[@id='homefeatured']//li[contains(@class,'ajax_block_product')]"+'['+productIndex+']'));
                //select any product - input Product name & price -- to do

            }else {

                product= driver.findElement(By.xpath("//ul[@id='blockbestsellers']//li[contains(@class,'ajax_block_product')]"+'['+productIndex+']'));


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
            WebElement btnContinue = this.driver.findElement(By.xpath("//span[contains(@class,'continue')]"));
            btnContinue.click();
            Thread.sleep(5000);
        }

        public void addToCart_continueShopping(String tabName,int productIndex) throws InterruptedException {
            selectTab(tabName);
            WebElement product=selectAnyProduct(tabName,productIndex);
            addToCart(product);
            continueShopping();
            
        }

       public void addToCart_continueShopping() throws InterruptedException {
           selectTab(tabName);
           WebElement product=selectAnyProduct(tabName,productIndex);
           addToCart(product);
           continueShopping();

       }
   }

    public static void main(String[] args) throws Exception{

       WebDriver driver= configuracionDriver("http://automationpractice.com/index.php?");
        Product product = new Product(driver); //First constructor.
                product.addToCart_continueShopping("popular",1);
                product.selectAnyProduct("bestie",7);
                product.addToCart_continueShopping("popular",3);

        Product product2 = new Product(driver,"popular",1); //Second constructor.
                product2.addToCart_continueShopping();

        Product product3 = new Product(driver,"bestie",1);
                product3.addToCart_continueShopping();

              //add to cart & continue shopping
             // select tab
             // select any product
            // add to cart
            // continue shopping
            //end of add to cart & continue shopping

        driver.close();

    }


}

