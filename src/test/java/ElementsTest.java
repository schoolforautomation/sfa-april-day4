import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElementsTest {

    @Test
    public void elementsTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("http://school-for-automation.tech/signup.html");
        webDriver.manage().window().maximize();

        /* Table */
        List<WebElement> tableHeader = webDriver.findElements(By.xpath("//*[@id=\"t01\"]/tbody/tr[1]/th"));
        Assert.assertEquals(tableHeader.get(0).getText(), "Course Name");
        Assert.assertEquals(tableHeader.get(1).getText(), "Level");
        Assert.assertEquals(tableHeader.get(2).getText(), "Sessions");

        List<WebElement> tableRow1 = webDriver.findElements(By.xpath("//*[@id=\"t01\"]/tbody/tr[2]/td"));
        Assert.assertEquals(tableRow1.get(0).getText(), "REST API with Java");
        Assert.assertEquals(tableRow1.get(1).getText(), "Beginner");
        Assert.assertEquals(tableRow1.get(2).getText(), "4");

        /* Radio */
        List<WebElement> radioButtons = webDriver.findElements(By.name("radio"));
        radioButtons.get(3).click();
        Assert.assertTrue(radioButtons.get(3).isSelected());

        /* Select dropdown */
        Select select = new Select(webDriver.findElement(By.id("slct")));
        select.selectByVisibleText("Advanced");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Advanced");

        webDriver.close();
    }
}
