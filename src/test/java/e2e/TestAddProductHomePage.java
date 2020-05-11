package e2e;

import com.auto.ui.PageObject.Product;
import com.auto.ui.PageObject.ShoppingCart;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestAddProductHomePage extends TestBase {

    Product homepage ;
    ShoppingCart carrito;

@BeforeSuite
public void Beforeall(){
    homepage=PageFactory.initElements(driver,Product.class);
    carrito= PageFactory.initElements(driver,ShoppingCart.class);

}


@Test(testName = "Add to Cart by Product Name")
    public void AddProductByName() throws InterruptedException{

        homepage.addToCart_continueShopping("popular","Printed Dress");
        homepage.addToCart_continueShopping("popular","Faded Short Sleeve T-shirts");

        Assert.assertEquals(carrito.getsNumberOfProducts(),2);
}
    @Test (testName = "Add to Cart by productIndex")
    public void AddProductsToCart() throws InterruptedException {

        homepage.addToCart_continueShopping("popular",4);
        homepage.addToCart_continueShopping("popular",1);
        homepage.addToCart_continueShopping("popular",2);

        Assert.assertEquals(carrito.getsNumberOfProducts(),5);

    }



}
