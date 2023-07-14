package com.hicarod.tests;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.TestCase;

public class GoogleTest extends TestCase {
  private WebDriver driver;
  private String baseUrl = "https://www.google.com";
  private String driverPath = "src/test/java/com/hicarod/resources/geckodriver";

  @Override
  protected void setUp() throws Exception {
    System.setProperty("webdriver.firefox.driver", driverPath);
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.get(baseUrl);
  }

  @Test
  public void testMustSearchOnGoogle() throws Exception {
    // Obtem o campo de input
    WebElement input = driver.findElement(By.name("q"));

    // Pesquisa Corinthians no Google
    input.sendKeys("corinthians");
    input.sendKeys(Keys.ENTER);

    // Pega lista de spans da página atual
    Thread.sleep(2000); // Espere dois segundos para página carregar
    List<WebElement> spans = driver.findElements(By.tagName("span"));

    // Pega o texto do elemento que contém as estatísticas
    boolean hasCorinthiansTextField = spans.stream().anyMatch(span -> span.getText().contains("Corinthians"));

    // Garanta que existe um span com Corinthians dentro
    assertTrue(hasCorinthiansTextField);
  }

  @Override
  protected void tearDown() throws Exception {
    driver.quit();
  }
}
