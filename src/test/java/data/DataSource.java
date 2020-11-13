package data;
import org.json.simple.JSONObject;

import org.testng.annotations.DataProvider;



public class DataSource {

    static JSONObject productDetails;


    @DataProvider(name = "dressesFieldsData")
    public static Object[][] getdressesfield() throws InterruptedException {
        productDetails = new JSONObject();
        productDetails.put("Index", (1));
        productDetails.put("Title", "Printed Dress");
        productDetails.put("Price", new Float(50.99));
        productDetails.put("WishList", true);
        productDetails.put("Compare", true);

        return new Object[][]{
                {
                        productDetails
                }

        };


    }
}
