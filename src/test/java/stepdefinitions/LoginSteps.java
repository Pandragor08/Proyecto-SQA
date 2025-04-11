package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.LoginPageElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverActions;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginSteps {
    private WebDriverWait wait;
    private final String VALID_USERNAME = "Admin";
    private final String VALID_PASSWORD = "admin123";

    @Before
    public void setup() {
        this.wait = new WebDriverWait(DriverActions.getDriver(), Duration.ofSeconds(10));
    }

    @Given("La usuario está en la página de inicio de sesión {string}")
    public void userIsOnLoginPage(String url) {
        DriverActions.openURL(url);
        DriverActions.maximizeWindow();
    }

    @When("La usuario introduce credenciales válidas")
    public void userEntersValidCredentials() {
        DriverActions.waitAndSendKeys(LoginPageElements.USERNAME_FIELD, VALID_USERNAME);
        DriverActions.waitAndSendKeys(LoginPageElements.PASSWORD_FIELD, VALID_PASSWORD);
        DriverActions.click(LoginPageElements.LOGIN_BUTTON);
    }

    @Then("El usuario debe ser redirigido a la página de inicio.")
    public void userIsRedirectedToHomepage() {
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        assertEquals(expectedUrl, DriverActions.getCurrentUrl());
    }

    @Then("Debería mostrarse un mensaje de bienvenida")
    public void welcomeMessageIsDisplayed() {
        WebElement mensaje = DriverActions.waitForElement(LoginPageElements.WELCOME_MESSAGE);
        assertTrue(mensaje.isDisplayed());
    }

    @After
    public void tearDown() {
        DriverActions.closeDriver();
    }
}
