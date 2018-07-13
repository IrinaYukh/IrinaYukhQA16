
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Trello
{
  private WebDriver driver;

  @BeforeClass(alwaysRun = true)
  public void setUp()
  {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void testTrello()
  {
    openSite();
    clickSignUpButton();
    fillNameField();
    fillEmailField();
    fillPasswordField();
    clickOnSignOutButton();
  }

  public void clickSignUpButton()
  {
    driver.findElement(By.linkText("Sign Up")).click();
  }

  public void clickOnSignOutButton()
  {
    driver.findElement(By.id("signup")).click();
  }

  public void fillPasswordField() {
    driver.findElement(By.xpath("//html")).click();
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("tr951753852");
  }

  public void fillEmailField() {
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("iyukhnovetsky@gmail.com");
  }

  public void fillNameField() {
    driver.findElement(By.id("name")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("Irina");
  }

  public void openSite() {
    driver.get("https://trello.com/");
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws InterruptedException
  {
    // Make a pause before close browser
    Thread.sleep(5000);
    driver.quit();
  }

  private boolean isElementPresent(By locator)
  {
    try
    {
      driver.findElement(locator);
      return true;
    }
    catch (NoSuchElementException e)
    {
      return false;
    }
  }


}
