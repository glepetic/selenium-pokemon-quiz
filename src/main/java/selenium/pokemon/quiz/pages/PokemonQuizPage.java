package selenium.pokemon.quiz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
>>>>>>> 7f354f3b15ecb0a88066e048c42fbe799b2439ef

<<<<<<< HEAD
<<<<<<< HEAD
=======
    @FindBy(id = "userPct")
    private WebElement score;

    @FindBy(id = "gameOverMsg")
    private WebElement gameOverMsg;

>>>>>>> 22d22db... Change readme
=======
    @FindBy(id = "userPct")
    WebElement score;

    @FindBy(id = "gameOverMsg")
    WebElement gameOverMsg;

>>>>>>> 056ef8f... 4553RT5 100% SC0R3
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

    public Integer getResultPoints(){
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(gameOverMsg));
        return Integer.parseInt(score.getText());
    }
}
