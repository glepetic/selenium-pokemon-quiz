package com.despegar.jav.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Pokemon1GenPage {

    private WebDriver driver;

    public Pokemon1GenPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(className = "button-wrapper")
    WebElement startButton;

    @FindBy(id = "gameinput")
    WebElement input;

    public void start(){
        startButton.click();
    }

    public void setPokemons(List<String> pokemons){
        pokemons.forEach(input::sendKeys);
    }
}
