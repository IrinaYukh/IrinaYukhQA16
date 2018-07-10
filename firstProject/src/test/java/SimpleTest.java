import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SimpleTest
{
    @Test
    public void navigateToQALightWebSite()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Web browser window will open on max.size
        driver.get("https://qalight.com.ua/");
        driver.quit();
    }
}
