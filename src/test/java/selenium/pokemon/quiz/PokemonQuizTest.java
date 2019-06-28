package selenium.pokemon.quiz;

import com.fasterxml.jackson.core.type.TypeReference;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
import org.junit.Assert;
>>>>>>> 056ef8f... 4553RT5 100% SC0R3
import selenium.pokemon.quiz.dtos.Pokemon;
import selenium.pokemon.quiz.pages.PokemonQuizPage;
=======
>>>>>>> c1482ac... Remove unnecessary stuff. Add os distinction for driver
=======
>>>>>>> 7f354f3b15ecb0a88066e048c42fbe799b2439ef
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
<<<<<<< HEAD
<<<<<<< HEAD

<<<<<<< HEAD
import java.util.Arrays;
=======
=======
import selenium.pokemon.quiz.utils.SeleniumUtils;
>>>>>>> c1482ac... Remove unnecessary stuff. Add os distinction for driver
import selenium.pokemon.quiz.utils.Sorter;

>>>>>>> bc3f83e... Make sort for conflicts in pokemon names more efficient
=======
>>>>>>> f90bb26... P4R4 T0D45 L45 G3N3R4C10N35
=======
>>>>>>> 056ef8f... 4553RT5 100% SC0R3
=======
import selenium.pokemon.quiz.utils.SeleniumUtils;
import selenium.pokemon.quiz.utils.Sorter;

>>>>>>> 7f354f3b15ecb0a88066e048c42fbe799b2439ef
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
<<<<<<< HEAD
<<<<<<< HEAD
//        driver.close();
=======
        driver.close();
>>>>>>> 056ef8f... 4553RT5 100% SC0R3
=======
        SeleniumUtils.closeDriver(driver);
>>>>>>> 7f354f3b15ecb0a88066e048c42fbe799b2439ef
    }

    private void completePokemonQuiz(String url, Integer initialId, Integer finalId) {
        driver.get(url);
        PokemonQuizPage pokemonQuizPage = new PokemonQuizPage(driver);
        pokemonQuizPage.start();
        List<String> genPokemonNames =
                new Sorter().sortByNameLength(pokemonNames.subList(initialId - 1, finalId));
        pokemonQuizPage.setPokemons(genPokemonNames);
        Assert.assertEquals((Integer) 100, pokemonQuizPage.getResultPoints());
    }

    @Test
    public void testPoke(){
        completePokemonQuiz(pokemonQuizBaseUrl + "g/pokemon",1,151);
    }

<<<<<<< HEAD
        driver = new ChromeDriver(capabilities);
        driver.manage().window().maximize();
=======
        SeleniumUtils.closeDriver(driver);
>>>>>>> c1482ac... Remove unnecessary stuff. Add os distinction for driver
=======
    @Test
    public void testPokeGen2(){
        completePokemonQuiz(pokemonQuizBaseUrl + "g/pokemongen2",152,251);
>>>>>>> 7f354f3b15ecb0a88066e048c42fbe799b2439ef
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> f90bb26... P4R4 T0D45 L45 G3N3R4C10N35
    private void completePokemonQuiz(String url, Integer initialId, Integer finalId){
        driver.get(url);
        PokemonQuizPage pokemonQuizPage = new PokemonQuizPage(driver);
        pokemonQuizPage.start();
<<<<<<< HEAD
<<<<<<< HEAD
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
<<<<<<< HEAD
    public void testPoke(){
<<<<<<< HEAD
        driver.get("https://www.sporcle.com/games/g/pokemon");
        PokemonQuizPage pokemon1GenPage = new PokemonQuizPage(driver);
        pokemon1GenPage.start();
        pokemon1GenPage.setPokemons(Arrays.asList("pikachu","raichu"));
=======
        completePokemonQuiz(pokemonQuizBaseUrl + "g/pokemon",1,151);
=======
        pokemonQuizPage.setPokemons(pokemonNames.subList(initialId-1,finalId));
=======
        List<String> genPokemonNames =
                pokeNameConflictService.sortPokemonNamesToAvoidConflicts(pokemonNames.subList(initialId-1, finalId));
        pokemonQuizPage.setPokemons(genPokemonNames);
        Assert.assertEquals((Integer) 100, pokemonQuizPage.getResultPoints());
>>>>>>> 056ef8f... 4553RT5 100% SC0R3
    }

    @Test
    public void testPoke(){
        completePokemonQuiz("https://www.sporcle.com/games/g/pokemon",1,151);
>>>>>>> f90bb26... P4R4 T0D45 L45 G3N3R4C10N35
    }

    @Test
    public void testPokeGen2(){
<<<<<<< HEAD
        completePokemonQuiz(pokemonQuizBaseUrl + "g/pokemongen2",152,251);
=======
        completePokemonQuiz("https://www.sporcle.com/games/g/pokemongen2",152,251);
>>>>>>> f90bb26... P4R4 T0D45 L45 G3N3R4C10N35
    }

    @Test
    public void testPokeGen3(){
<<<<<<< HEAD
        completePokemonQuiz(pokemonQuizBaseUrl + "g/pokemongen3",252,386);
=======
        completePokemonQuiz("https://www.sporcle.com/games/g/pokemongen3",252,386);
>>>>>>> f90bb26... P4R4 T0D45 L45 G3N3R4C10N35
    }

    @Test
    public void testPokeGen4(){
<<<<<<< HEAD
        completePokemonQuiz(pokemonQuizBaseUrl + "g/pokemongen4",387,493);
=======
        completePokemonQuiz("https://www.sporcle.com/games/g/pokemongen4",387,493);
>>>>>>> f90bb26... P4R4 T0D45 L45 G3N3R4C10N35
    }

    @Test
    public void testPokeGen5(){
<<<<<<< HEAD
        completePokemonQuiz(pokemonQuizBaseUrl + "BluePikmin/pokemongen5",494,649);
=======
        completePokemonQuiz("https://www.sporcle.com/games/BluePikmin/pokemongen5",494,649);
>>>>>>> f90bb26... P4R4 T0D45 L45 G3N3R4C10N35
    }

    @Test
    public void testPokeGen6(){
<<<<<<< HEAD
        completePokemonQuiz(pokemonQuizBaseUrl + "dertswa687o/pokemon-gen-vi",650,721);
=======
        completePokemonQuiz("https://www.sporcle.com/games/dertswa687o/pokemon-gen-vi",650,721);
>>>>>>> f90bb26... P4R4 T0D45 L45 G3N3R4C10N35
=======
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
>>>>>>> 7f354f3b15ecb0a88066e048c42fbe799b2439ef
    }

    @Test
    public void testPokeGen7(){
<<<<<<< HEAD
<<<<<<< HEAD
        completePokemonQuiz(pokemonQuizBaseUrl + "dertswa687o/pokemon-gen-vii",722,802);
>>>>>>> c1482ac... Remove unnecessary stuff. Add os distinction for driver
=======
        completePokemonQuiz("https://www.sporcle.com/games/dertswa687o/pokemon-gen-vii",722,802);
>>>>>>> f90bb26... P4R4 T0D45 L45 G3N3R4C10N35
=======
        completePokemonQuiz(pokemonQuizBaseUrl + "dertswa687o/pokemon-gen-vii",722,802);
>>>>>>> 7f354f3b15ecb0a88066e048c42fbe799b2439ef
    }

}
