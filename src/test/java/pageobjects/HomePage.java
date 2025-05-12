package pageobjects;

import org.openqa.selenium.By;
import utils.DriverActions;

public class HomePage extends DriverActions {

    // Locators
    public static final By AMOR_CATEGORY = By.xpath("(//a[text()='Amor'])[3]");
    public static final By CUMPLEAÑOS_CATEGORY = By.xpath("(//a[text()='Cumpleaños'])[3]");
    public static final By PRODUCT_1 = By.xpath("(//div[@id='main-content']//div[contains(@class, 'type-product')])[1]");
    public static final By PRODUCT_2 = By.xpath("(//div[@id='main-content']//div[contains(@class, 'type-product')])[2]");
    public static final By ADD_TO_CART_1 = By.xpath("(//a[contains(@class,'add_to_cart_button')])[1]");
    public static final By ADD_TO_CART_2 = By.xpath("(//a[contains(@class,'add_to_cart_button')])[2]");
    public static final By NUMBER = By.xpath("//*[@id=\"main\"]/div/div/div/div/div[2]/div/div/div/div[2]/form/div/table/tbody/tr[1]/td[4]/div/input[2]");
    public static final By DELETE = By.xpath("//a[@class=\"remove\"]");
    public static final By text = By.xpath("//div[@class=\"cart-empty woocommerce-info\"]");


    public static String setText() {
        scrollToElement(NUMBER);
        return obtenerTexto(NUMBER);
    }

    public static void sectionAmor() {
        waitForElement(AMOR_CATEGORY);
        click(AMOR_CATEGORY);
    }

    public static void deleteProduct() {
        click(DELETE);
    }

    public static void sectionCumpleanos() {
        click(CUMPLEAÑOS_CATEGORY);
    }


    public static void addProductToCart(By productLocator, By addToCartButtonLocator) {
        scrollToElement(productLocator);
        hoverProduct(productLocator);
        click(addToCartButtonLocator);
    }

    public static void addProductsToCart1() {
        waitForElement(PRODUCT_1);
        addProductToCart(PRODUCT_1, ADD_TO_CART_1);
        click(AMOR_CATEGORY);
    }

    public static void addProductsToCart2() {
        waitForElement(PRODUCT_2);
        addProductToCart(PRODUCT_2, ADD_TO_CART_2);
        click(AMOR_CATEGORY);
    }
}

