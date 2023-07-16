package com.hicarod.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject extends BasePageObject {
  @FindBy(id = "email")
  public WebElement emailInput;

  @FindBy(id = "senha")
  public WebElement passwordInput;

  @FindBy(id = "mensagem")
  public WebElement errorMessage;

  @FindBy(id = "btn-entrar")
  public WebElement submitButton;

  public LoginPageObject(WebDriver driver) {
    super(driver);
  }

  public String getCurrentPageTitle() {
    return driver.getTitle();
  }

  public void fillEmail(String email) {
    emailInput.clear();
    emailInput.sendKeys(email);
  }

  public void fillPassword(String password) {
    passwordInput.clear();
    passwordInput.sendKeys(password);
  }

  public String getErrorMessage() {
    return errorMessage.getText();
  }

  public void login(String email, String password) {
    clearFields();
    if (email != null) {
      fillEmail(email);
    }
    if (password != null) {
      fillPassword(password);
    }

    submitCredentials();
  }

  public void clearFields() {
    emailInput.clear();
    passwordInput.clear();
  }

  public void submitCredentials() {
    submitButton.click();
  }
}
