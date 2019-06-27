package selenium.pokemon.quiz;

import selenium.pokemon.quiz.pages.PokemonQuizPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;

public class PokemonQuizTest {

    private static WebDriver driver;

    @BeforeClass
    public static void openBrowser(){
        System.setProperty("webdriver.chrome.driver", PokemonQuizTest.class.getClassLoader()
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
        PokemonQuizPage pokemon1GenPage = new PokemonQuizPage(driver);
        pokemon1GenPage.start();
        pokemon1GenPage.setPokemons(Arrays.asList("pikachu","raichu"));
    }
}
