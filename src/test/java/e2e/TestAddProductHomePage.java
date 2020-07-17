package e2e;

import com.auto.ui.PageObject.Checkout;
import com.auto.ui.PageObject.Login;
import com.auto.ui.PageObject.Product;
import com.auto.ui.PageObject.ShoppingCart;
import com.google.gson.JsonObject;
import org.apache.commons.compress.utils.Lists;
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
    Checkout checkout;
    Login loginandOut;

@BeforeSuite
public void Beforeall(){
    homepage=PageFactory.initElements(driver,Product.class);
    carrito= PageFactory.initElements(driver,ShoppingCart.class);
    checkout= PageFactory.initElements(driver,Checkout.class);
    loginandOut=PageFactory.initElements(driver,Login.class);
}


@Test(testName = "Add to Cart by Product Name",priority = 1)
    public void AddProductByName() throws InterruptedException{

        homepage.addToCart_continueShopping("popular","Printed Dress");
        homepage.addToCart_continueShopping("popular","Faded Short Sleeve T-shirts");
        homepage.addToCart_continueShopping("popular","Printed Chiffon Dress");
        homepage.addToCart_continueShopping("popular","Printed Chiffon Dress");
        Assert.assertEquals(carrito.getsNumberOfProducts(),7);


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
    listica.add("Printed Chiffon Dress");


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
/*
    homepage.Total_price=50;
    System.out.println("total amount modificado " + homepage.Total_price);
*/
        System.out.println("The total amount is " + homepage.getTotalPrice());
        Assert.assertEquals(carrito.getTotalInShoppingCart(), homepage.getTotalPrice());

}
    @Test(testName="Check price after dropped Item",priority = 4,enabled = false)
    public void CheckTrashcan() throws InterruptedException{


            //Printed Dress

        Assert.assertEquals(Math.round((homepage.getTotalPrice()-carrito.DropItemfromCart("Printed Chiffon Dress"))*100.0)/100.0, Math.round((carrito.getTotalInShoppingCart())*100.0)/100.0);

    }
    @Test(testName="Check price after dropped Item from list",priority = 5)
    public void CheckListTrashcan() throws InterruptedException{


        //Printed Dress

        Assert.assertEquals(carrito.DropItemfromlist("Printed Chiffon Dress"), carrito.getTotalInShoppingCart());

    }


    @Test(testName="Signining in with products",priority = 6)
    public void CheckoutproductsCartList() throws InterruptedException{

        checkout.clickCheckout();
        Assert.assertEquals(loginandOut.isLogin(),false);

        loginandOut.login("juandjllo@yandex.com","laclave12345");
        Thread.sleep(5000);

        Assert.assertEquals(loginandOut.isLogin(),true);
        //Printed Dress

        //Assert.assertEquals(carrito.DropItemfromlist("Printed Chiffon Dress"), carrito.getTotalInShoppingCart());

    }

    @Test(testName="Checking delivery address",priority = 7)
    public void CheckdeliveryAddress() throws InterruptedException{


        JsonObject addressDeliverytoTest = new JsonObject();
        addressDeliverytoTest.addProperty("Name","Juan David");
        addressDeliverytoTest.addProperty("Address","4545");
        addressDeliverytoTest.addProperty("City","dubai, Arizona 00000");
        addressDeliverytoTest.addProperty("Country","United States");
        addressDeliverytoTest.addProperty("Phone","3333333333");

        Assert.assertEquals(checkout.getDeliveryaddress(),addressDeliverytoTest);
    }


}
