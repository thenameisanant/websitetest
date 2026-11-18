package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebpageTest {

    private static WebDriver driver;

    @BeforeTest
    public void openBrowser() throws InterruptedException {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        Thread.sleep(2000);

        driver.get("YOUR_GITHUB_PAGES_URL");
    }

    @Test
    public void titleValidationTest() {

        String actualTitle = driver.getTitle();

        String expectedTitle = "Tripillar Solutions";

        Assert.assertEquals(actualTitle, expectedTitle);

        Assert.assertTrue(
                actualTitle.contains("Tripillar"),
                "Title should contain Tripillar"
        );
    }

    @AfterTest
    public void closeBrowser() {

        if (driver != null) {
            driver.quit();
        }
    }
}