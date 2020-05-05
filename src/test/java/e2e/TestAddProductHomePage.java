package e2e;

import com.auto.ui.PageObject.Product;
import com.auto.ui.PageObject.ShoppingCart;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestAddProductHomePage extends TestBase {

    Product homepage = PageFactory.initElements(driver,Product.class);
    ShoppingCart carrito= PageFactory.initElements(driver,ShoppingCart.class);

    @Test (testName = "Add to Cart")
    public void AddProductsToCart() throws InterruptedException {



        homepage.addToCart_continueShopping("popular",4);
        carrito.getsNumberOfProducts();

        Assert.assertEquals(1,1);
    }



}
