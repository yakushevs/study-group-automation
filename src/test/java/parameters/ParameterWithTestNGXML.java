package parameters;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ParameterWithTestNGXML {
    @Test
    @Parameters({"envUrl"})
    public void testParameterWithXML(String envUrl) throws InterruptedException{


        System.out.println("Direcciòn " +envUrl);



    }
}