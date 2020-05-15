package e2e;

import com.auto.ui.PageObject.Product;
import com.auto.ui.PageObject.ShoppingCart;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class TestAddProductHomePage extends TestBase {

    Product homepage ;
    ShoppingCart carrito;

@BeforeSuite
public void Beforeall(){
    homepage=PageFactory.initElements(driver,Product.class);
    carrito= PageFactory.initElements(driver,ShoppingCart.class);

}


@Test(testName = "Add to Cart by Product Name",priority = 1)
    public void AddProductByName() throws InterruptedException{

        homepage.addToCart_continueShopping("popular","Printed Dress");
        homepage.addToCart_continueShopping("popular","Faded Short Sleeve T-shirts");

        Assert.assertEquals(carrito.getsNumberOfProducts(),5);


}


    @Test (testName = "Add to Cart by productIndex",priority = 0)
    public void AddProductsToCart() throws InterruptedException {

        homepage.addToCart_continueShopping("popular",4);
        homepage.addToCart_continueShopping("popular",1);
        homepage.addToCart_continueShopping("popular",2);

        Assert.assertEquals(carrito.getsNumberOfProducts(),3);

    }

@Test (testName = "Product in cart",priority = 2)
    public void ProductsinCart() throws InterruptedException {

    Thread.sleep(1500);
    List<String> listica = new ArrayList<>();
    listica.add("Printed Summer Dress");
    listica.add("Blouse");
    listica.add("Printed Dress");
    listica.add("Faded Short Sleeve T-shirts");
     System.out.println(listica);
    //carrito.getsProductsNameInCart();
    Assert.assertEquals(carrito.getsProductsNameInCart(),listica);

}

}
