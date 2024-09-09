package StepDefinitions;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.LoggerUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.LoginPage_PF;

public class login {

	static WebDriver driver = Hooks.getDriver();
	String username;
	LoginPage_PF LoginPage = new LoginPage_PF(driver);

	@Given("when user navigate to login page")
	public void when_user_navigate_to_login_page() {
		LoggerUtil.getLogger().info("Navigate to Login Page");
		LoginPage.goTo();
	}

	@When("user enter the {string} and {string}")
	public void user_enter_the_username_and_password(String userName, String password) {
		this.username = userName;
		LoggerUtil.getLogger().info("Enter UserName and Password");
		LoginPage.enterUserName(userName);
		LoginPage.enterPassword(password);
	}

	@And("user click the login button")
	public void user_click_the_login_button() {
		LoggerUtil.getLogger().info("Click Login button");
		LoginPage.clickLoginButton();
	}

	@Then("validate that user is landed on home page and see welcome messgae")
	public void validate_that_user_is_landed_on_home_page() {
		LoggerUtil.getLogger().info("Validate the success message display on valid credential");
		String success = driver.findElement(By.tagName("strong")).getText();
		assertTrue(success.contains("Congratulations " + this.username + ". You successfully logged in!"));
		assertTrue(driver.getCurrentUrl().contains("/logged-in-successfully"));
	}

}
