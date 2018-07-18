package packOne;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static java.lang.Thread.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class demoTests {

    WebDriver driver;

    @BeforeTest
    public void setup() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/Users/thanosbabalas/Desktop/newreportapp/src/main/resources/chromedriver");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.github.com");
        driver.manage().window().maximize();
    }

    @Test (priority = 0)
    //1st TC - Passed
    public void firstTestCase() throws InterruptedException
    {
        assertTrue(isElementPresent(By.xpath(("/html/body/div[4]/div[1]/div/div/div[2]/div/form/button"))));
        sleep(5000);
    }
    @Test (priority = 1)
    //2nd TC - Passed
    public void secondTestCase() throws InterruptedException {
                assertFalse(isElementPresent(By.xpath(("//*[@id='app__container']/div[2]/header"))));
        sleep(5000);
    }

    @Test (priority = 3)
    //3rd TC - Failed
    public void thirdTestCase() throws InterruptedException {
        assertTrue(isElementPresent(By.xpath(("//*[@id='app__container']/div[789]/header"))));
        sleep(5000);
    }

    @Test (priority = 2)
    //4th TC - Passed
    public void forthTestCase() throws InterruptedException {
        assertTrue(isElementPresent(By.xpath(("/html/body/div[4]/div[1]/div/div/div[1]/h1"))));
        sleep(5000);
    }

    @AfterTest
    public void driverQuit(){
        driver.close();
        driver.quit();
    }

    public Boolean isElementPresent(By by) {
        if (driver.findElements(by).size() > 0)
            return true;
        else
            return false;
    }
}
