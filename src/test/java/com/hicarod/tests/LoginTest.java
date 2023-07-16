package com.hicarod.tests;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.javafaker.Faker;
import com.hicarod.pages.LoginPageObject;

public class LoginTest extends BaseTest {
  private static Faker faker;
  private static LoginPageObject loginPage;

  @BeforeClass
  public static void beforeTest() {
    loginPage = new LoginPageObject(driver);
    faker = new Faker();
  }

  @Test
  public void mustReturnErrorWhenEmailAndPasswordWereNotPassed() {
    loginPage.login(null, null);
    String errorMessage = loginPage.getErrorMessage();
    assertEquals(errorMessage, "Informe usuário e senha, os campos não podem ser brancos.");
  }

  @Test
  public void mustReturnErrorWhenPasswordIsEmpty() {
    String fakeEmail = faker.internet().password();
    loginPage.login(fakeEmail, null);

    String errorMessage = loginPage.getErrorMessage();

    assertEquals(errorMessage, "Informe usuário e senha, os campos não podem ser brancos.");
  }

  @Test
  public void mustReturnErrorWhenEmailIsEmpty() {
    String fakePassword = faker.internet().password();
    loginPage.login(null, fakePassword);

    String errorMessage = loginPage.getErrorMessage();

    assertEquals(errorMessage, "Informe usuário e senha, os campos não podem ser brancos.");
  }

  @Test
  public void mustReturnInvalidCredentialsErrorWhenCredentialsAreIncorrect() {
    String fakeEmail = faker.internet().emailAddress();
    String fakePassword = faker.internet().password();

    loginPage.login(fakeEmail, fakePassword);

    String errorMessage = loginPage.getErrorMessage();

    assertEquals(errorMessage, "E-mail ou senha inválidos");
  }

  @AfterClass
  public static void afterTest() {
    driver.quit();
  }
}
