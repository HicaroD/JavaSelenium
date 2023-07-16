package com.hicarod.tests;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.github.javafaker.Faker;
import com.hicarod.pages.LoginPageObject;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest {
  private static Faker faker;
  private static LoginPageObject loginPage;

  @BeforeClass
  public static void beforeTest() {
    loginPage = new LoginPageObject(driver);
    faker = new Faker();
  }

  @Test
  public void TC001_mustReturnErrorWhenEmailAndPasswordWereNotPassed() {
    loginPage.login(null, null);
    String errorMessage = loginPage.getErrorMessage();
    assertEquals(errorMessage, "Informe usuário e senha, os campos não podem ser brancos.");
  }

  @Test
  public void TC002_mustReturnErrorWhenPasswordIsEmpty() {
    String fakeEmail = faker.internet().password();
    loginPage.login(fakeEmail, null);

    String errorMessage = loginPage.getErrorMessage();

    assertEquals(errorMessage, "Informe usuário e senha, os campos não podem ser brancos.");
  }

  @Test
  public void TC003_mustReturnErrorWhenEmailIsEmpty() {
    String fakePassword = faker.internet().password();
    loginPage.login(null, fakePassword);

    String errorMessage = loginPage.getErrorMessage();

    assertEquals(errorMessage, "Informe usuário e senha, os campos não podem ser brancos.");
  }

  @Test
  public void TC004_mustReturnInvalidCredentialsErrorWhenCredentialsAreIncorrect() {
    String fakeEmail = faker.internet().emailAddress();
    String fakePassword = faker.internet().password();

    loginPage.login(fakeEmail, fakePassword);

    String errorMessage = loginPage.getErrorMessage();

    assertEquals(errorMessage, "E-mail ou senha inválidos");
  }

  @Test
  public void TC005_mustSuccessfullyLogIntoTheSystemWhenEmailAndPasswordAreCorrect() {
    String validEmail = "admin@admin.com";
    String validPassword = "admin@123";

    loginPage.login(validEmail, validPassword);

    String errorMessage = loginPage.getErrorMessage();
    String pageTitle = loginPage.getCurrentPageTitle();

    assertEquals(errorMessage, "");
    assertEquals(pageTitle, "Controle de Produtos");
  }

  @AfterClass
  public static void afterTest() {
    driver.quit();
  }
}
