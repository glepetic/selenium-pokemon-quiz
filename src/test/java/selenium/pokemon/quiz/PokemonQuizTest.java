package selenium.pokemon.quiz;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import selenium.pokemon.quiz.dtos.Pokemon;
import selenium.pokemon.quiz.pages.PokemonQuizPage;
import selenium.pokemon.quiz.utils.FileHandler;
import selenium.pokemon.quiz.utils.JsonHandler;
import selenium.pokemon.quiz.utils.SeleniumUtils;
import selenium.pokemon.quiz.utils.Sorter;

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
        SeleniumUtils.closeDriver(driver);
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
    }

}
