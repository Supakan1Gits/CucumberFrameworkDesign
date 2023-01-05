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
		amazonPage.amazonSearchBox.click();
	}

	@Then("I should see the search item {string} on search result page")
	public void i_should_see_the_search_item_on_search_result_page(String items) {
		utils.waitUntilElementVisible(amazonPage.amazonSearchBox);
		Assert.assertEquals(amazonPage.amazonSearchBox.getAttribute("value"), items);
		
	}

}
