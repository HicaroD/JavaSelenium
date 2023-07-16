package com.hicarod.tests;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.hicarod.builders.Product;
import com.hicarod.pages.LoginPageObject;
import com.hicarod.pages.ProductPageObject;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductTest extends BaseTest {
  private static LoginPageObject loginPage;
  private static ProductPageObject productPage;

  @BeforeClass
  public static void beforeTest() {
    loginPage = new LoginPageObject(driver);
    loginPage.login("admin@admin.com", "admin@123");

    productPage = new ProductPageObject(driver);
    assertEquals(loginPage.getCurrentPageTitle(), "Controle de Produtos");
  }

  @Test
  public void TC001_mustOpenProductCreatorModalWhenClickingInCreateButton() {
    productPage.reload();
    productPage.clickOnCreateProductButton();
    assertEquals("Produto", productPage.modalHeaderTitle.getText());
  }

  @Test
  public void TC002_mustFillAllFieldsForCreatingAProduct() {
    productPage.reload();
    productPage.clickOnCreateProductButton();
    productPage.clearAllFields();
    productPage.saveProduct();

    String errorMessage = productPage.getErrorMessage();
    assertEquals("Todos os campos são obrigatórios para o cadastro!", errorMessage);
  }

  @Test
  public void TC003_mustCloseModalWhenClickingOnExitButton() {
    productPage.reload();
    productPage.clickOnCreateProductButton();

    String productModalTitle = productPage.modalHeaderTitle.getText();
    assertEquals("Produto", productModalTitle);
    productPage.closeModal();
    String productModalTitleAfterClosingModal = productPage.modalHeaderTitle.getText();
    assertEquals("", productModalTitleAfterClosingModal);
  }

  @Test
  public void TC004_mustCreateAProduct() {
    productPage.reload();
    productPage.clickOnCreateProductButton();

    Product product = new Product();
    productPage.createProduct(product);
  }

  @AfterClass
  public static void afterTest() {
    driver.quit();
  }
}
