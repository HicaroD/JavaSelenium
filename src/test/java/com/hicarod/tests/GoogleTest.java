package com.hicarod.tests;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hicarod.pages.GooglePageObject;

public class GoogleTest extends BaseTest {
  private static GooglePageObject googlePage;

  @BeforeClass
  public static void beforeTest() {
    googlePage = new GooglePageObject(driver);
  }

  @Test
  public void testMustSearchOnGoogle() throws Exception {
    // Pesquisa Corinthians no Google
    googlePage.search("corinthians");

    // Pega o parágrafo que contém os resultados
    Thread.sleep(2000); // Espere dois segundos para página carregar
    String resultStats = googlePage.resultStats.getText();

    assertTrue(resultStats.contains("Aproximadamente"));
  }

  @AfterClass
  public static void afterTest() {
    driver.quit();
  }
}
