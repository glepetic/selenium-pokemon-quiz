package selenium.pokemon.quiz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PokemonQuizPage {

    private WebDriver driver;

    public PokemonQuizPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(className = "button-wrapper")
    private WebElement startButton;

    @FindBy(id = "gameinput")
    private WebElement input;

<<<<<<< HEAD
=======
    @FindBy(id = "userPct")
    private WebElement score;

    @FindBy(id = "gameOverMsg")
    private WebElement gameOverMsg;

>>>>>>> 22d22db... Change readme
    public void start(){
        startButton.click();
    }

    public void setPokemons(List<String> pokemons){
        pokemons.forEach(this::clearAndSetPokemon);
    }

    private void clearAndSetPokemon(String pokemon){
        input.clear();
        input.sendKeys(pokemon);
    }
}
