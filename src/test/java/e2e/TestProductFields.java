package e2e;

import com.auto.ui.PageObject.Product;
import com.auto.ui.PageObject.ProductFields;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;

import org.testng.annotations.DataProvider;

public class TestProductFields extends TestBase {

    ProductFields prodfields;
    JSONObject JsonProductFieldsUI;

    @BeforeSuite
    public void Beforeall() {
        prodfields = PageFactory.initElements(driver, ProductFields.class);


    }
    @Test(testName = "Validate Product fields",priority = 1)
    public void ValidateFields() throws InterruptedException{


        prodfields.ClickproductDresses();
        prodfields.SelectDress(0);
        System.out.println("La prenda es "+ prodfields.getTitle() +" y su condición es " + prodfields.getCondition());
        System.out.println("Ladescripciòn es "+prodfields.getShortdesc());
        // Assert.assertEquals(carrito.getsNumberOfProducts(),6);


    }
    @Test(testName = "Validate Product Fields with json", dataProviderClass = data.DataSource.class ,dataProvider = "dressesFieldsData", priority = 0)
    public void  validateProductFields(JSONObject dressesData) throws InterruptedException {
        int productIndex = (int) dressesData.get("Index");
        prodfields.ClickproductDresses();
        System.out.println("Clicked Dresses link");
        JsonProductFieldsUI = new JSONObject();
        JsonProductFieldsUI= prodfields.selectProduct(productIndex);
        System.out.println("product : " + JsonProductFieldsUI);
        Assert.assertEquals(JsonProductFieldsUI,dressesData);
    }

}