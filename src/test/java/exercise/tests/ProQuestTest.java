package exercise.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.DriverUtil;
import util.FileUtil;

import java.util.List;

public class ProQuestTest {

    // Initializing variables and objects
    WebDriver driver;

    // Executes before each tests
    @BeforeTest
    public void before(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        // Open chrome browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    // Test no. 1
    @Test
    public void ValidateProQuestGoogleSearch(){
        // Navigating to google
        driver.get("https://www.google.com");
        // Locating search text box
        WebElement searchTxtBox = driver.findElement(By.xpath("//input[@aria-label='Search']"));
        // Searching for ProQuest
        searchTxtBox.sendKeys("ProQuest");
        searchTxtBox.sendKeys(Keys.ENTER);
        // Getting list of titles element
        List<WebElement> listTitles = driver.findElements(By.xpath("//a/h3"));

        StringBuilder builder = new StringBuilder();
        // Getting list of titles element into a string
        for(WebElement title : listTitles) {
            if(title.getText().trim().length() > 0){
                builder.append(title.getText());
                builder.append("\n");
            }
        }
        // Writing all the title to a text file
        FileUtil.writeToFile("titles.txt", builder.toString());
    }

    // Test no. 2
    @Test
    public void ValidateProQuestQASearch(){

        // Navigating to google
        driver.get("https://www.proquest.com/");

        driver.findElement(By.xpath("//a[@class=' dropdown-toggle ']")).click();

        driver.findElement(By.xpath("(//input[@name='searchKeyword'])[2]")).sendKeys("QA", Keys.ENTER);

        // Take Screenshot and save it to a file
        DriverUtil.takeSnapShot(driver, "test-screenshot.png");
    }

    // Executes after each tests
    @AfterTest
    public void after() {
        // Closing the driver
        driver.quit();
    }

}
