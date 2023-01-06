package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonPage;
import utils.BrowserUtils;
import utils.Driver;

public class AmazonSerach {
	
	AmazonPage amazonPage = new AmazonPage();
	BrowserUtils utils = new BrowserUtils();
	
	@Given("I am on the amazon homepage")
	public void i_am_on_the_amazon_homepage() {
		
	    Driver.getDriver().get("https://amazon.com");
	    
	}

	@When("I enter the search term {string}")
	public void i_enter_the_search_term(String items) {
	    amazonPage.amazonSearchBox.sendKeys(items);
	}

	@When("I click on search button")
	public void i_click_on_search_button() {
		amazonPage.searchBtn.click();
	}

	@Then("I should see the search item {string} on search result page")
	public void i_should_see_the_search_item_on_search_result_page(String items) {
		utils.waitUntilElementVisible(amazonPage.amazonSearchBox);
		String originalText = amazonPage.searchedItemText.getText();
		Assert.assertEquals(originalText.substring(1, items.length()+1), items);
//		Assert.assertEquals(amazonPage.amazonSearchBox.getAttribute("value"), items);
		
	}
	
	@Then("the page title should contain the searched item {string}")
	public void the_page_title_should_contain_the_searched_item(String items) {
		// another easy way is
		Assert.assertEquals(Driver.getDriver().getTitle().substring(13), items);
				
	    String title = Driver.getDriver().getTitle();
	    Assert.assertEquals(title.substring(title.length() - items.length()), items);
	}

}
