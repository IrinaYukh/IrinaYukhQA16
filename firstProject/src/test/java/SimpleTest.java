import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SimpleTest
{
    @Test
    public void navigateToQALightWebSite()
    {
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();
        if (driver != null)
        {
            for (int i = 0; i<50; i++)
            {
                //driver.manage().window().setSize(new Dimension(100,200));
                driver.manage().window().maximize(); // Web browser window will open on max.size
                driver.get("https://qalight.com.ua/");
            }
            driver.quit();
        }
        else
        {
            System.out.println("Empty");
        }
    }
}
