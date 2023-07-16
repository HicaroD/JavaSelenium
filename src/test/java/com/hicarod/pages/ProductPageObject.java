package com.hicarod.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hicarod.builders.Product;

public class ProductPageObject extends BasePageObject {
  @FindBy(xpath = "/html/body/nav/div/ul/li/a")
  public WebElement backButton;

  @FindBy(xpath = "/html/body/nav/a")
  public WebElement homeButton;

  @FindBy(id = "btn-adicionar")
  public WebElement createProductButton;

  @FindBy(css = "div>div.modal-dialog")
  public WebElement modalDialog;

  @FindBy(className = "modal-title")
  public WebElement modalHeaderTitle;

  @FindBy(id = "codigo")
  public WebElement productCodeField;

  @FindBy(id = "nome")
  public WebElement productNameField;

  @FindBy(id = "quantidade")
  public WebElement productQuantityField;

  @FindBy(id = "valor")
  public WebElement productValueField;

  @FindBy(id = "data")
  public WebElement productRegisterDateField;

  @FindBy(id = "btn-salvar")
  public WebElement saveProductButton;

  @FindBy(id = "btn-sair")
  public WebElement closeProductModalButton;

  @FindBy(id = "mensagem")
  public WebElement errorMessage;

  public ProductPageObject(WebDriver driver) {
    super(driver);
  }

  public void clickOnCreateProductButton() {
    // TODO: modal only opens when clicking two, however it is not the proper
    // behavior
    createProductButton.click();
    createProductButton.click();
  }

  public void clearAllFields() {
    productCodeField.clear();
    productNameField.clear();
    productValueField.clear();
    productQuantityField.clear();
    productRegisterDateField.clear();
  }

  public String getErrorMessage() {
    return errorMessage.getText();
  }

  public void saveProduct() {
    saveProductButton.click();
  }

  public void createProduct(Product product) {
    clearAllFields();
    productCodeField.sendKeys(product.code.toString());
    productNameField.sendKeys(product.name);
    productValueField.sendKeys(product.value.toString());
    productQuantityField.sendKeys(product.quantitity.toString());
    productRegisterDateField.sendKeys(product.registerDate);
    saveProduct();
  }

  public void closeModal() {
    closeProductModalButton.click();
    // TODO: i need to click two times for closing the modal
    closeProductModalButton.click();
  }

  public void reload() {
    driver.navigate().refresh();
  }
}
