package com.hicarod.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject extends BasePageObject {
  @FindBy(id = "email")
  WebElement emailInput;

  @FindBy(id = "senha")
  WebElement passwordInput;

  @FindBy(id = "mensagem")
  WebElement errorMessage;

  @FindBy(id = "btn-entrar")
  WebElement submitButton;

  public LoginPageObject(WebDriver driver) {
    super(driver);
  }

  public void fillEmail(String email) {
    emailInput.clear();
    emailInput.sendKeys(email);
  }

  public void fillPassword(String password) {
    emailInput.clear();
    passwordInput.sendKeys(password);
  }

  public void submitCredentials() {
    submitButton.click();
  }
}
