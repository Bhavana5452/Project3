package com.testngPackage;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;

public class TestngTestCase {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLinkCountAndUrls() {
        driver.get("https://www.flipkart.com/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total Links: " + links.size());
        for (int i = 0; i < links.size(); i++) {
            String linkText = links.get(i).getText();
            String linkUrl = links.get(i).getAttribute("href");
            System.out.println((i+1) + ". Link Text: " + linkText + " - URL: " + linkUrl);
        }
        Assert.assertTrue(links.size() > 0);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
