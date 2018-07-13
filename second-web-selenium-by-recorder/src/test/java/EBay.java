

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EBay
{
  private WebDriver driver;

  @BeforeClass(alwaysRun = true)
  public void setUp()
  {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  @Test
  public void testEBay()
  {
    open_eBaySite();

    click_signIn_button();

    fill_userId_field();

    fill_Pass_field();

    click_signIn_formButton();
  }

  public void open_eBaySite()
  {
    driver.get("https://www.ebay.com/");
  }

  public void click_signIn_button()
  {
    //driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.xpath("//*[@id=\"gh-ug\"]/a")).click();
  }

  public void fill_userId_field()
  {
    driver.findElement(By.id("userid")).click();
    driver.findElement(By.id("userid")).clear();
    driver.findElement(By.id("userid")).sendKeys("iyukhnovetsky@gmail.com");
  }

  public void fill_Pass_field()
  {
    driver.findElement(By.id("pass")).click();
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("iy3161");
  }

  public void click_signIn_formButton()
  {
    driver.findElement(By.id("sgnBt")).click();
  }


  @AfterClass(alwaysRun = true)
  public void tearDown()
  {
    try {
      Thread.sleep(1000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    driver.quit();

  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }


}
