package StepDefinitions;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utils.LoggerUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {

	private static WebDriver driver;

	@BeforeAll()
	public static void setUp() {
		System.getProperty("WebDriver.Chrome.Driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@AfterAll
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@After
	public void afterScenario(Scenario scenario) {
		LoggerUtil.getLogger().info("Scenario finished: " + scenario.getName());

		// Attach logs to the Cucumber report
		String logFilePath = "target/test-logs/log4j2.log";
		try {
			byte[] logFileContent = Files.readAllBytes(Paths.get(logFilePath));
			scenario.attach(logFileContent, "text/plain", "============ Click here to view the Scenario OUTPUT ==========");
		} catch (IOException e) {
			LoggerUtil.getLogger().error("Failed to read log file", e);
		}
		try (FileWriter writer = new FileWriter(logFilePath, false)) {
			// This will clear the file content
			writer.write("");
		} catch (IOException e) {
			LoggerUtil.getLogger().error("Failed to clear log file", e);
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
