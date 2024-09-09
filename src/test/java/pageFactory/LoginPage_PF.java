package pageFactory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.ReadConfig;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage_PF {
	private Wait<WebDriver> webDriverWait = null;
	WebDriver driver;
	private By userNameTextBox = By.cssSelector("input[name='username']");
	private By passwordTextBox = By.cssSelector("input[name='password']");
	private By loginButton = By.cssSelector("#submit");

	public LoginPage_PF(WebDriver driver) {
		this.driver = driver;
	}

	public void goTo() {
		driver.navigate().to(ReadConfig.getProperty("loginPage"));
	}

	public void enterUserName(String UserName) {
		webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = webDriverWait.until(ExpectedConditions.elementToBeClickable(userNameTextBox));
		element.sendKeys(UserName);
	}

	public void enterPassword(String Password) {
		driver.findElement(passwordTextBox).sendKeys(Password);
	}

	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
}
