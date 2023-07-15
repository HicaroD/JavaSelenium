package com.hicarod.tests;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseTest {
  protected static WebDriver driver;
  private static String baseUrl = "https://www.google.com";
  private static String driverPath = "src/test/java/com/hicarod/resources/geckodriver";

  @BeforeClass
  public static void setUp() {
    System.setProperty("webdriver.firefox.driver", driverPath);
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.get(baseUrl);
  }
}
