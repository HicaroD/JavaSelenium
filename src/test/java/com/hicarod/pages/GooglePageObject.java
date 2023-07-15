package com.hicarod.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePageObject extends BasePageObject {
  @FindBy(name = "q")
  public WebElement googleSearchBar;

  @FindBy(id = "result-stats")
  public WebElement resultStats;

  public GooglePageObject(WebDriver driver) {
    super(driver);
  }

  public void search(String searchQuery) {
    googleSearchBar.sendKeys(searchQuery + Keys.ENTER);
  }
}
