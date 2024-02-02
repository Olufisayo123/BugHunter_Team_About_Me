import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fissy\\OneDrive\\Documents\\BugHunter_Team_About_Me\\FaceBook\\Resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://selenium-blog.herokuapp.com");
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            System.out.println("Correct and valid Url");
        else
            System.out.println("Invalid Url");
        Thread.sleep(10000);
        driver.manage().window().maximize();
        // click on sign up button
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(10000);
    }

    @Test(priority = 0)
    public void PositiveSignUp() throws InterruptedException {
        driver.findElement(By.id("user_username")).sendKeys("Ayoadettttt123");
        driver.findElement(By.id("user_email")).sendKeys("ffissytttttttttayoade@gmail.com");
        driver.findElement(By.id("user_password")).sendKeys("admin");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(10000);
    }

    @Test(priority = 1)
    public void clickUserItems() throws InterruptedException {
        // click on User1 item on the list
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        //Test-3
        String expectedUrl="https://selenium-blog.herokuapp.com/signup";
        String actualUrl=driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            System.out.println("Right");
        else
            System.out.println("wrong");
        Thread.sleep(10000);
    }

    @Test(priority = 2)
    public void verifyItem() throws InterruptedException {
        // search for an item  (using python with Selenium) and confirm if it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        String expectedPageUrl = "/users/1";
        String actualPageUrl = driver.getTitle();
        if (actualPageUrl.contains(expectedPageUrl))
            System.out.println("Right");
        else
            System.out.println("wrong");
        Thread.sleep(10000);
    }

    @Test(priority = 3)
    public void logOutSuccessfully() {
        // click on logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        String expectedTitle = "AlphaBlog";
        String actualTitle= driver.getCurrentUrl();
        if (actualTitle.contains(expectedTitle))
            System.out.println("Right");
        else
            System.out.println("wrong");
    }


    @Test(priority = 4)
    public void negativeSignUp() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        driver.findElement(By.id("user_username")).sendKeys("Ay");
        driver.findElement(By.id("user_email")).sendKeys("ffissyayoade@gmail.com");
        driver.findElement(By.id("user_password")).sendKeys("admin");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(10000);
    }

    @AfterClass
    public void tearDown() {
            driver.quit();
    }
}
