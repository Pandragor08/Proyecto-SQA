package org.example;

import org.openqa.selenium.By;

public class LoginPageElements {
    public static final By USERNAME_FIELD = By.name("username");
    public static final By PASSWORD_FIELD = By.name("password");
    public static final By LOGIN_BUTTON = By.xpath("//div/button");
    public static final By WELCOME_MESSAGE = By.xpath("//h6[text()='Dashboard']");
}