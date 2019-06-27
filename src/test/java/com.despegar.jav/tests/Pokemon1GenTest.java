package com.despegar.jav.tests;

import com.despegar.jav.pages.Pokemon1GenPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;

public class Pokemon1GenTest {

    private static WebDriver driver;

    @BeforeClass
    public static void openBrowser(){
        System.setProperty("webdriver.chrome.driver", Pokemon1GenTest.class.getClassLoader()
                .getResource("drivers/chromedriver_linux64").getPath());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type", "--disable-impl-side-painting", "disable-infobars",
                "--silent", "--lang=en-GB");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new ChromeDriver(capabilities);
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void closeBrowser(){
//        driver.close();
    }

    @Test
    public void testPoke(){
        driver.get("https://www.sporcle.com/games/g/pokemon");
        Pokemon1GenPage pokemon1GenPage = new Pokemon1GenPage(driver);
        pokemon1GenPage.start();
        pokemon1GenPage.setPokemons(Arrays.asList("pikachu","raichu"));
    }
}
