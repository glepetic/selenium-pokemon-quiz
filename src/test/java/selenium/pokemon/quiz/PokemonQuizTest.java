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
<<<<<<< HEAD

import java.util.Arrays;
=======
import selenium.pokemon.quiz.utils.Sorter;

>>>>>>> bc3f83e... Make sort for conflicts in pokemon names more efficient
import java.util.List;
import java.util.stream.Collectors;

public class PokemonQuizTest {

    private static WebDriver driver;
    private static List<String> pokemonNames;
    private Sorter sorter = new Sorter();

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

<<<<<<< HEAD
<<<<<<< HEAD
=======
    private void completePokemonQuiz(String url, Integer initialId, Integer finalId){
        driver.get(url);
        PokemonQuizPage pokemonQuizPage = new PokemonQuizPage(driver);
        pokemonQuizPage.start();
        List<String> pokemon = pokeNameConflictService.sortPokemonNamesToAvoidConflicts(pokemonNames.subList(initialId-1, finalId));
        pokemonQuizPage.setPokemons(pokemon);
=======
    private void completePokemonQuiz(String url, Integer initialId, Integer finalId) {
        driver.get(url);
        PokemonQuizPage pokemonQuizPage = new PokemonQuizPage(driver);
        pokemonQuizPage.start();
        List<String> genPokemonNames =
                sorter.sortByNameLength(pokemonNames.subList(initialId - 1, finalId));
        pokemonQuizPage.setPokemons(genPokemonNames);
        Assert.assertEquals((Integer) 100, pokemonQuizPage.getResultPoints());
>>>>>>> bc3f83e... Make sort for conflicts in pokemon names more efficient
    }

>>>>>>> dcdb713... Fix for names with conflict
    @Test
    public void testPoke(){
        driver.get("https://www.sporcle.com/games/g/pokemon");
        PokemonQuizPage pokemon1GenPage = new PokemonQuizPage(driver);
        pokemon1GenPage.start();
        pokemon1GenPage.setPokemons(Arrays.asList("pikachu","raichu"));
    }
}
