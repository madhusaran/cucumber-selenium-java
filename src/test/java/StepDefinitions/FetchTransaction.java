package StepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageFactory.Transaction_PF;

public class FetchTransaction {
	
	static WebDriver driver = Hooks.getDriver();

	Transaction_PF transactionPage = new Transaction_PF(driver);

	@Given("User navigate to transaction page")
	public void user_navigate_to_transaction_page() {
	    transactionPage.goTo();
	}

	@Then("Fecth the transactions with value {string} than {float}")
	public void fecth_the_transaction_with_value_than(String condition, float value) {
	    transactionPage.fetchTransction(condition, value);
	    
	}
}
