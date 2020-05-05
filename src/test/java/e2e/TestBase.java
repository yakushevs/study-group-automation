package e2e;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase  {
    WebDriver driver ;

    @BeforeSuite
    public void BeforeAll() {
        WebDriverManager.chromedriver().version("80.0.3987.106").setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");
    }

@AfterSuite
    public void AfterAll() throws InterruptedException {

        Thread.sleep(1500);
        driver.close();

    }
}
