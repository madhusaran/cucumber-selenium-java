package pageFactory;

import java.nio.file.Paths;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.LoggerUtil;

public class Transaction_PF {
	WebDriver driver;
	private By Rows = By.cssSelector("table tr");
	private By amountColumn = By.cssSelector("table tr>td:nth-child(4)");

	public Transaction_PF(WebDriver driver) {
		this.driver = driver;
	}

	public void goTo() {
		String filePath = Paths.get("src/test/resources/sampleWebTables/sample.html").toUri().toString();
		driver.navigate().to(filePath);
	}

	public void fetchTransction(String Condition, Float value) {
		List<WebElement> tableRows = driver.findElements(Rows);
		List<WebElement> amount = driver.findElements(amountColumn);

		for (int i = 0; i < amount.size() - 1; i++) {
			double tableValue = Float.parseFloat(amount.get(i).getText());
			if (Condition.contains("<")) {
				if (tableValue < value) {
					LoggerUtil.getLogger().info(tableRows.get(i+1).getText());
					System.out.println(tableRows.get(i+1).getText());
				}
			} else if (Condition.contains(">")) {
				if (tableValue > value) {
					LoggerUtil.getLogger().info(tableRows.get(i+1).getText());
					System.out.println(tableRows.get(i+1).getText());
				}
			} else if (Condition.contains("=")) {
				if (tableValue == value) {
					LoggerUtil.getLogger().info(tableRows.get(i+1).getText());
					System.out.println(tableRows.get(i+1).getText());
				}
			}
		}

	}
}
