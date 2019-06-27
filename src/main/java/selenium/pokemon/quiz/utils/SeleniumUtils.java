package selenium.pokemon.quiz.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class SeleniumUtils {

    private static final Logger LOGGER = getLogger(SeleniumUtils.class);

    public static WebDriver buildDriver(){
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/main/resources/drivers/" + driverDependingOnOS());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars", "--silent");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver(WebDriver driver){
        LOGGER.info("Closing driver");
        driver.close();
    }

    private static String driverDependingOnOS(){
        String os = System.getProperty("os.name").toUpperCase();
        if(os.contains("LINUX")) return "chromedriver_linux64";
        else if(os.contains("MAC")) return "chromedriver_mac64";
        else return "chromedriver";
    }

}
