package selenium.pokemon.quiz;

import com.fasterxml.jackson.core.type.TypeReference;
<<<<<<< HEAD
import selenium.pokemon.quiz.dtos.Pokemon;
import selenium.pokemon.quiz.pages.PokemonQuizPage;
=======
>>>>>>> c1482ac... Remove unnecessary stuff. Add os distinction for driver
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import selenium.pokemon.quiz.dtos.Pokemon;
import selenium.pokemon.quiz.pages.PokemonQuizPage;
import selenium.pokemon.quiz.utils.FileHandler;
import selenium.pokemon.quiz.utils.JsonHandler;
<<<<<<< HEAD
<<<<<<< HEAD

import java.util.Arrays;
=======
=======
import selenium.pokemon.quiz.utils.SeleniumUtils;
>>>>>>> c1482ac... Remove unnecessary stuff. Add os distinction for driver
import selenium.pokemon.quiz.utils.Sorter;

>>>>>>> bc3f83e... Make sort for conflicts in pokemon names more efficient
import java.util.List;
import java.util.stream.Collectors;

public class PokemonQuizTest {

    private static final String pokemonQuizBaseUrl = "https://www.sporcle.com/games/";
    private static WebDriver driver;
    private static List<String> pokemonNames;

    @BeforeClass
    public static void openBrowser(){
        driver = SeleniumUtils.buildDriver();
        List<Pokemon> pokemons = new JsonHandler().deserialize(
                new FileHandler().getContent("pokemon.json", false),
                        new TypeReference<List<Pokemon>>(){});
        pokemonNames = pokemons.stream().map(pokemon -> pokemon.getName().getEnglish()).collect(Collectors.toList());
    }

    @AfterClass
    public static void closeBrowser(){
<<<<<<< HEAD
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
=======
        SeleniumUtils.closeDriver(driver);
>>>>>>> c1482ac... Remove unnecessary stuff. Add os distinction for driver
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
                new Sorter().sortByNameLength(pokemonNames.subList(initialId - 1, finalId));
        pokemonQuizPage.setPokemons(genPokemonNames);
        Assert.assertEquals((Integer) 100, pokemonQuizPage.getResultPoints());
>>>>>>> bc3f83e... Make sort for conflicts in pokemon names more efficient
    }

>>>>>>> dcdb713... Fix for names with conflict
    @Test
    public void testPoke(){
<<<<<<< HEAD
        driver.get("https://www.sporcle.com/games/g/pokemon");
        PokemonQuizPage pokemon1GenPage = new PokemonQuizPage(driver);
        pokemon1GenPage.start();
        pokemon1GenPage.setPokemons(Arrays.asList("pikachu","raichu"));
=======
        completePokemonQuiz(pokemonQuizBaseUrl + "g/pokemon",1,151);
    }

    @Test
    public void testPokeGen2(){
        completePokemonQuiz(pokemonQuizBaseUrl + "g/pokemongen2",152,251);
    }

    @Test
    public void testPokeGen3(){
        completePokemonQuiz(pokemonQuizBaseUrl + "g/pokemongen3",252,386);
    }

    @Test
    public void testPokeGen4(){
        completePokemonQuiz(pokemonQuizBaseUrl + "g/pokemongen4",387,493);
    }

    @Test
    public void testPokeGen5(){
        completePokemonQuiz(pokemonQuizBaseUrl + "BluePikmin/pokemongen5",494,649);
    }

    @Test
    public void testPokeGen6(){
        completePokemonQuiz(pokemonQuizBaseUrl + "dertswa687o/pokemon-gen-vi",650,721);
    }

    @Test
    public void testPokeGen7(){
        completePokemonQuiz(pokemonQuizBaseUrl + "dertswa687o/pokemon-gen-vii",722,802);
>>>>>>> c1482ac... Remove unnecessary stuff. Add os distinction for driver
    }

}
