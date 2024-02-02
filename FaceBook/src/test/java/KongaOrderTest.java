import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class KongaOrderTest {
    private WebDriver driver;

    @Test
    public void start() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fissy\\OneDrive\\Documents\\BugHunter_Team_About_Me\\FaceBook\\Resources\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://www.konga.com");
        Thread.sleep(10000);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id='nav-bar-fix']/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("username")).sendKeys("ayoadefissy@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Ayoade1st,");
        driver.findElement(By.xpath("//*[@id='app-content-wrapper']/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(10000);

        WebElement computersCategory = driver.findElement(By.linkText("Computers and Accessories"));
        computersCategory.click();
        Thread.sleep(10000);

        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[4]/div/div/div[3]/form/div[4]/button")).click();
        Thread.sleep(10000);

        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[1]/div/div[1]/div/a[2]")).click();
        Thread.sleep(10000);

        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(10000);

        driver.findElement(By.id("firstname")).sendKeys("Ayoade");
        driver.findElement(By.id("lastname")).sendKeys("tunde");
        driver.findElement(By.id("telephone")).sendKeys("+2348138496207");
        driver.findElement(By.id("street")).sendKeys("22, Baruwa Street, Woleola Estate, Gbongan/Ibadan, express way");
        driver.findElement(By.id("city")).sendKeys("osogbo");
        Thread.sleep(10000);

        Select drpCountry = new Select(driver.findElement(By.name("regionId")));
        drpCountry.selectByVisibleText("Osun");
        Thread.sleep(10000);

        drpCountry = new Select(driver.findElement(By.name("areaId")));
        drpCountry.selectByVisibleText("Osogbo");
        Thread.sleep(10000);

        driver.findElement(By.xpath("//*[@id='app-content-wrapper']/div[2]/section/section/aside/div[2]/div/div/form/div[8]/div[1]/button")).click();
        Thread.sleep(10000);

        driver.findElement(By.xpath("//*[@id='app-content-wrapper']/div[2]/section/section/aside/div[2]/div/div/div[2]/div/form/button")).click();
        Thread.sleep(10000);

        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        driver.findElement(By.xpath("//*[@id='mainContent']/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();

        driver.findElement(By.xpath("//*[@id='mainContent']/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(29000);

        Thread.sleep(1000);

        String originalWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        WebElement paymentModal = driver.findElement(By.id("kpg-frame-component"));
        driver.switchTo().frame(paymentModal);
        WebElement paymentElement = driver.findElement(By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[3]/button"));
        if (paymentElement.isDisplayed()) {
            paymentElement.click();
            Thread.sleep(10000);
            driver.findElement(By.id("card-number")).sendKeys("1234 5678 9012 3456");
            Thread.sleep(10000);
            driver.findElement(By.id("expiry")).sendKeys("09/25");
            Thread.sleep(10000);
            driver.findElement(By.id("cvv")).sendKeys("123");
            Thread.sleep(10000);
            driver.findElement(By.xpath("//*[@id='validateCardForm']")).click();
            WebElement errorMessage = driver.findElement(By.xpath("//*[@id='input-card-no-container']"));
            //Assert.assertEquals(errorMessage.getText(), "Invalid card number");
           // System.out.println(errorMessage.getText());
            //WebElement closeButton = driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside']"));
            //closeButton.click();
            driver.switchTo().defaultContent();
        }
        // Switch back to the main window

    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}
