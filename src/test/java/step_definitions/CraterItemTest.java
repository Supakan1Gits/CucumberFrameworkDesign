package step_definitions;



import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterDashboardPage;
import pages.CraterItemsPage;
import pages.CraterLoginPage;
import utils.BrowserUtils;
import utils.Driver;
import utils.TestDataReader;

public class CraterItemTest {

	CraterLoginPage craterLogin = new CraterLoginPage();
	CraterDashboardPage dashboard = new CraterDashboardPage();
	CraterItemsPage itemsPage = new CraterItemsPage();
	BrowserUtils utils = new BrowserUtils();
	
	String itemName = "coffee machine";
	
	
	@Given("user navigates to Items tab")
	public void user_navigates_to_items_tab() throws InterruptedException {
		Driver.getDriver().get(TestDataReader.getProperty("craterUrl"));
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    craterLogin.login();
	    utils.waitUntilElementVisible(itemsPage.itemsLink);
		itemsPage.itemsLink.click();
	}

	@When("user clicks on the Add Item button and user should be on item input page")
	public void user_clicks_on_the_add_item_button_and_user_should_be_on_item_input_page() {
		utils.waitUntilElementVisible(itemsPage.addItemButton);
		itemsPage.addItemButton.click();
		Assert.assertTrue(itemsPage.newItemText.isDisplayed());
	}

	@When("user provides item information {string} and {string} and {string} and {string}")
	public void user_provides_item_information_and_and_and(String name, String price, 
			String unit, String description) {
		 itemName = itemName + utils.randomNumber();
		 utils.waitUntilElementVisible(itemsPage.itemNameField);
		 itemsPage.itemNameField.sendKeys(itemName);
		 itemsPage.itemPriceField.sendKeys("15000");
		  
		 itemsPage.itemUnitField.click();
		 itemsPage.itemUnitPC.click();
		 itemsPage.itemDescriptionField.sendKeys("black espresso machine");
	    
	}

	@When("click Save Item button")
	public void click_save_item_button() {
		itemsPage.saveButton.click();
	}

	@Then("the Item is added to the Item list table")
	public void the_item_is_added_to_the_item_list_table() {
		utils.waitUntilElementVisible(itemsPage.itemCreateSuccessMessage);
	    Assert.assertTrue(itemsPage.itemCreateSuccessMessage.isDisplayed());
	    
	    WebElement newItem = Driver.getDriver().findElement(By.xpath("//a[text()='"+itemName+"']"));
		Assert.assertTrue(newItem.isDisplayed());
	}
	
	//update item
	
	@When("selects the item {string} and user should be on item details page")
	public void selects_the_item_and_user_should_be_on_item_details_page(String book) {
		utils.waitUntilElementVisible(itemsPage.filterItemButton);
	    itemsPage.filterItemButton.click();
	    itemsPage.filterNameField.sendKeys(book);
	    itemsPage.BookLink.click();
	    
	    utils.waitUntilElementVisible(itemsPage.editItemHeaderText);
	    Assert.assertTrue(itemsPage.editItemHeaderText.isDisplayed());
	    
	}

	@When("user updates the item price to {int} dollars")
	public void user_updates_the_item_price_to_dollars(Integer price) {
		if (itemsPage.itemPriceField.getText() != "3000") {
			  utils.clearTextOfAFieldMac(itemsPage.itemPriceField);
			  itemsPage.itemPriceField.sendKeys("3000");
		  } else {
			  
		  }
	}

	@When("click Update Item button")
	public void click_update_item_button() {
		  itemsPage.updateItemButton.click();
		 
	}

	@Then("the Item price is updated to {int} dollars")
	public void the_item_price_is_updated_to_dollars(Integer int1) {
		utils.waitUntilElementVisible(itemsPage.itemPageBookPrice);
		Assert.assertEquals(itemsPage.itemPageBookPrice.getText(), "$ 30.00");
	}

}
