import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SynchronizationTest {

    @Test
    public void synchronizationTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("http://school-for-automation.tech/home.html");
        webDriver.manage().window().maximize();

        /* Thread.sleep() */
        Thread.sleep(3000);
        WebElement getStartedButton = webDriver.findElement(By.id("get-started"));
        Assert.assertTrue(getStartedButton.isDisplayed());

        /* Implicit wait */
        // webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // WebElement getStartedButton = webDriver.findElement(By.id("get-started"));
        // Assert.assertTrue(getStartedButton.isDisplayed());

        /* Explicit waits */
        // WebElement getStartedButton = new WebDriverWait(webDriver, 3)
        //         .until(ExpectedConditions.elementToBeClickable(By.id("get-started")));
        // WebElement getStartedButton = new WebDriverWait(webDriver, 3)
        //         .until(localWebDriver -> localWebDriver.findElement(By.id("get-started")));
        // Assert.assertTrue(getStartedButton.isDisplayed());

        /* Fluent wait */
        // Wait<WebDriver> wait = new FluentWait<>(webDriver)
        //         .withTimeout(Duration.ofSeconds(10))
        //         .pollingEvery(Duration.ofSeconds(2))
        //         .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        //
        // WebElement getStartedButton = wait.until(localWebDriver -> localWebDriver.findElement(By.id("get-started")));
        // Assert.assertTrue(getStartedButton.isDisplayed());

        webDriver.close();
    }
}
