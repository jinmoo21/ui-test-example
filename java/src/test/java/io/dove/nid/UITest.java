package io.dove.nid;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.dove.nid.page.LoginPage;
import io.dove.nid.page.FooPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class UITest {
	private static final int TIMEOUT = 5;
	private WebDriver driver;
	private LoginPage loginPage;
	private FooPage mainPage;
	
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
	}
	
	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Parameters({"account", "pw"})
	@Test(priority = 1)
	public void test01(String account, String pw) {
		loginPage = new LoginPage(driver);
		loginPage.get();
		loginPage.login(account, pw);
		assertTrue(driver.getCurrentUrl().contains("https://nid.naver.com/nidlogin.login"));
	}
}
