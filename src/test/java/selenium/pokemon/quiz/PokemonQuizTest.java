package selenium.pokemon.quiz;

import com.fasterxml.jackson.core.type.TypeReference;
import selenium.pokemon.quiz.dtos.Pokemon;
import selenium.pokemon.quiz.pages.PokemonQuizPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import selenium.pokemon.quiz.utils.FileHandler;
import selenium.pokemon.quiz.utils.JsonHandler;

import java.util.List;
import java.util.stream.Collectors;

public class PokemonQuizTest {

    private static WebDriver driver;
    private static List<String> pokemonNames;

    @BeforeClass
    public static void openBrowser(){
        initializeDriver();
        List<Pokemon> pokemons = new JsonHandler().deserialize(
                new FileHandler().getContent("pokemon.json", false),
                        new TypeReference<List<Pokemon>>(){});
        pokemonNames = pokemons.stream().map(pokemon -> pokemon.getName().getEnglish()).collect(Collectors.toList());
    }

    @AfterClass
    public static void closeBrowser(){
//        driver.close();
    }

    private static void initializeDriver(){
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver_linux64");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type", "--disable-impl-side-painting", "disable-infobars",
                "--silent", "--lang=en-GB");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new ChromeDriver(capabilities);
        driver.manage().window().maximize();
    }

    private void completePokemonQuiz(String url, Integer initialId, Integer finalId){
        driver.get(url);
        PokemonQuizPage pokemonQuizPage = new PokemonQuizPage(driver);
        pokemonQuizPage.start();
        pokemonQuizPage.setPokemons(pokemonNames.subList(initialId-1,finalId));
    }

    @Test
    public void testPoke(){
        completePokemonQuiz("https://www.sporcle.com/games/g/pokemon",1,151);
    }

    @Test
    public void testPokeGen2(){
        completePokemonQuiz("https://www.sporcle.com/games/g/pokemongen2",152,251);
    }

    @Test
    public void testPokeGen3(){
        completePokemonQuiz("https://www.sporcle.com/games/g/pokemongen3",252,386);
    }

    @Test
    public void testPokeGen4(){
        completePokemonQuiz("https://www.sporcle.com/games/g/pokemongen4",387,493);
    }

    @Test
    public void testPokeGen5(){
        completePokemonQuiz("https://www.sporcle.com/games/BluePikmin/pokemongen5",494,649);
    }

    @Test
    public void testPokeGen6(){
        completePokemonQuiz("https://www.sporcle.com/games/dertswa687o/pokemon-gen-vi",650,721);
    }

    @Test
    public void testPokeGen7(){
        completePokemonQuiz("https://www.sporcle.com/games/dertswa687o/pokemon-gen-vii",722,802);
    }
}
