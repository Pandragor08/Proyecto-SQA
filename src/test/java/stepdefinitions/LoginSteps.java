package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.HomePage;
import utils.DriverActions;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class LoginSteps extends HomePage {
    private WebDriverWait wait;


    @Before
    public void setup() {
        this.wait = new WebDriverWait(DriverActions.getDriver(), Duration.ofSeconds(10));
    }

    @Given("home {string}")
    public void userHomePage(String url) {
        DriverActions.openURL(url);
        DriverActions.maximizeWindow();
    }

    @When("navego a la sección {string}")
    public void navigateToSection(String sectionName) {
        sectionAmor();
    }

    @When("espero que los productos se carguen y seleccionar primer producto")
    public void selectFirstProduct() {
        addProductsToCart1();
        DriverActions.pauseForMilliseconds(5000);
    }

    @When("regresar a seccion amor y seleccionar 2do producto")
    public void selectSecondProduct() {
        sectionAmor();
        addProductsToCart2();
        DriverActions.pauseForMilliseconds(5000);
    }

    @Then("los dos productos deberían estar en el carro de compras")
    public void verifyProductsInCart() {
        String textoObtenido = setText();
        String textoEsperado = "2"; // Cambia esto al valor que esperas

        assertEquals("El producto en el carrito no coincide", textoEsperado, textoObtenido);
    }

    @When("navego a la sección cumple")
    public void navigateToSectionC(String sectionName) {
        sectionCumpleanos();
    }

    @When("eliminar objeto")
    public void deletProduct() {
        deleteProduct();
    }

    @Then("no se visualizara ningun objeto en carrito")
    public void verifyDeletProduct() {
        String textoObtenido = setText();
        String textoEsperado = "Tu carrito está vacío."; // Cambia esto al valor que esperas

        assertEquals("El producto en el carrito no coincide", textoEsperado, textoObtenido);
    }

    @After
    public void tearDown() {
        DriverActions.closeDriver();
    }
}
