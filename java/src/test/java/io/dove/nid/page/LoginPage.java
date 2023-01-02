package io.dove.nid.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

public class LoginPage extends LoadableComponent<LoginPage> {
	private static final int TIMEOUT = 5;
	private static final String URL = "https://nid.naver.com/nidlogin.login";
	private final WebDriver driver;
	
	@FindBy(css = "input#id")
	private WebElement id;
	@FindBy(css = "input#pw")
	private WebElement pw;
	@FindBy(css = "button[id='log.login']")
	private WebElement login;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	}

	@Override
	protected void load() {
		driver.get(URL);
	}

	@Override
	protected void isLoaded() throws Error {
		Assert.assertTrue(driver.getCurrentUrl().contains(URL));
	}
	
	public FooPage login(String id, String pw) {
		this.id.sendKeys(id);
		this.pw.sendKeys(pw);
		login.click();
		return new FooPage(driver);
	}
}
