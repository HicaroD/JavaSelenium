package com.hicarod.tests;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class GoogleTest extends BaseTest {
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
}
