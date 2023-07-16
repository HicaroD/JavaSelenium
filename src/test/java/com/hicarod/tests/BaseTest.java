package com.hicarod.tests;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseTest {
  protected static WebDriver driver;
  private static String baseUrl = "file:///home/hicaro/Documentos/Prototypes/curso_java_selenium/controle-de-produtos/sistema/login.html";
  private static String driverPath = "src/test/java/com/hicarod/resources/geckodriver";

  @BeforeClass
  public static void setUp() {
    System.setProperty("webdriver.firefox.driver", driverPath);
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.get(baseUrl);
  }
}
