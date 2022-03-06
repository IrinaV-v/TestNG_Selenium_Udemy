package testNGWeb;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.testng.Assert;
        import org.testng.annotations.Test;


public class TestNGGoogleSearchTest extends BaseTest{

    @Test
    void calcTest() {
        WebDriver driver = getDriver();
        WebElement agree = driver.findElement(By.xpath("//*[text()=\"Принимаю\"]"));
        agree.click();
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("sqrt 16");
        element.submit();

        WebElement result = driver.findElement(By.id("cwos"));
        Assert.assertEquals(result.getText(), "4");
    }

    @Test
    void searchTest() {
        //WebDriver driver = getDriver(BrowserType.FIREFOX, "http://www.google.com" );
        WebDriver driver = getDriver();

        WebElement agree = driver.findElement(By.xpath("//*[text()=\"Принимаю\"]"));
        agree.click();
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Selenium WebDriver");
        element.submit();

        Assert.assertTrue(driver.getTitle().startsWith("Selenium WebDriver"));
    }

}
