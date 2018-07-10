import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class OpenGoogleTest
{
    public  WebDriver driver = null;

    @BeforeMethod
    public void setUp()
    {
        driver = new ChromeDriver();
    }
@Test
public void siteOpeningTest(){
    //driver.get("https://www.odnoklassniki.ru");
    driver.get("https://www.google.com");
}

@AfterMethod
public void tearDown(){
    driver.quit();
}


}
