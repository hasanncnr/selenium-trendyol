package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
import java.util.Set;


public class AppTest
{
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");


        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incentigo");
        driver = new ChromeDriver(options);
        driver.get("https://www.trendyol.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(30),Duration.ofMillis(05));
      

    }
    @Test
    public void selenium() throws InterruptedException {
       WebElement element = driver.findElement(By.xpath("//div//a//span[text()='ERKEK']"));
       element.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.user-login-container")));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector("div.user-login-container"))).build().perform();
        driver.findElement(By.cssSelector("div.login-button")).click();

        driver.findElement(By.id("login-email")).sendKeys("hasancnr008@gmail.com");
        driver.findElement(By.id("login-password-input")).sendKeys("19941903Hc");
        driver.findElement(By.cssSelector("button.submit")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("div.search-box-container input.search-box")).sendKeys("Kazak");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("i.search-icon")).click();


        driver.findElement(By.xpath("//body")).click();
        Thread.sleep(3000);

        List<WebElement> elements = driver.findElements(By.cssSelector("div>div.prdct-cntnr-wrppr>div"));
        Thread.sleep(2000);
        elements.get(10).click();

        String currentWindows = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windows : windowHandles) {
            if (!currentWindows.equals(windows)) {
                driver.switchTo().window(windows);
            }
        }
        driver.findElement(By.cssSelector("div.favorite-button"));
        Thread.sleep(3000);

        //String price = driver.findElement(By.cssSelector("div.product-price-container span.prc-dsc")).getText();
        //System.out.println(price);

        //driver.findElement(By.cssSelector("div.selected.sp-itm")).click();
        driver.findElement(By.cssSelector("div .add-to-basket")).click();
        Thread.sleep(4000);


















    }







    @After
    public void tearDown(){
        driver.quit();
    }
}
