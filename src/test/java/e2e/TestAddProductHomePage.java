package e2e;

import com.auto.ui.PageObject.Product;
import com.auto.ui.PageObject.ShoppingCart;
import org.apache.commons.compress.utils.Lists;
import org.assertj.core.api.Condition;
import org.hamcrest.Matchers;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import java.util.List;

//import static org.assertj.core.api.Assertions.assertThat;


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

@Test (testName = "Products in cart by name",priority = 2)
    public void ProductsinCart() throws InterruptedException {

    Thread.sleep(1500);

    List<String> listica= Lists.newArrayList();
    //List<String> listica = new ArrayList<>();

    listica.add("Blouse");
    listica.add("Faded Short Sleeve T-shirts");
    listica.add("Printed Summer Dress");
    listica.add("Printed Dress");

         //Assert.assertEquals(carrito.getsProductsNameInCart(),listica);
    assertThat(carrito.getsProductsNameInCart(),containsInAnyOrder(listica.toArray()));
    assertThat(carrito.getsProductsNameInCart(),hasItems("Blouse","Faded Short Sleeve T-shirts"));

    //Assert.assertEquals(carrito.getsProductsNameInCart(),listica);
    System.out.println("Listica: "+ listica);
    System.out.println("Prendas desde metodo: "+ carrito.getsProductsNameInCart().toArray());
    System.out.println("Prendas desde metodo: "+ carrito.getsProductsNameInCart().size());


    /*
    assertThat(carrito.getsProductsNameInCart()).containsExactly("Printed Summer Dress","Blouse","Printed Dress","Faded Short Sleeve T-shirts")
                                                .endsWith("Faded Short Sleeve T-shirts")
                                                .hasSize(4);

        */
}

@Test(testName="comparing the price",priority = 3)
    public void CheckTotalPrice() throws InterruptedException{
            System.out.println("The total amount is " + homepage.getTotalPrice());
        Assert.assertEquals(carrito.getTotalInShoppingCart(), homepage.getTotalPrice());

}


}
