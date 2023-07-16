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
    driver.get("https://www.google.com");
    googlePage = new GooglePageObject(driver);
  }

  @Test
  public void mustSearchCorinthiansOnGoogle() throws Exception {
    googlePage.search("corinthians");
    Thread.sleep(2000);
    String resultStats = googlePage.resultStats.getText();
    assertTrue(resultStats.contains("Aproximadamente"));
  }

  @AfterClass
  public static void afterTest() {
    driver.quit();
  }
}
