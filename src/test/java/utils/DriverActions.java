package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverActions {
    static WebDriver driver;
    private static WebDriverWait wait;
    private static final String CHROME_DRIVER_PATH = "C:\\Users\\Karlos\\IdeaProjects\\PruebaConexion\\driver\\chromedriver.exe";

    public static void initializeDriver() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    public static void openURL(String url) {
        getDriver().get(url);
    }

    public static void maximizeWindow() {
        getDriver().manage().window().maximize();
    }

    public static String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public static void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public static void waitAndSendKeys(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    public static WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void hoverProduct(By productLocator) {
        WebElement element = waitForElement(productLocator);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
    }

    public static void pauseForMilliseconds(int milliseconds) {
        try {
            Thread.sleep(milliseconds); // Pausa la ejecución durante el tiempo indicado en milisegundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static String obtenerTexto(By locator) {
        try {
            WebElement elemento = driver.findElement(locator);

            // Intentar con getText()
            String texto = elemento.getText();
            if (texto != null && !texto.trim().isEmpty()) {
                return texto.trim();
            }

            // Revisar atributos comunes si getText está vacío
            String[] atributos = {"value", "placeholder", "textContent", "innerText", "aria-label", "title"};
            for (String attr : atributos) {
                texto = elemento.getAttribute(attr);
                if (texto != null && !texto.trim().isEmpty()) {
                    return texto.trim();
                }
            }

            return "[Elemento encontrado pero sin texto legible]";
        } catch (NoSuchElementException e) {
            return "[Elemento no encontrado]";
        } catch (Exception e) {
            return "[Error al obtener texto: " + e.getMessage() + "]";
        }
    }

    public static void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
