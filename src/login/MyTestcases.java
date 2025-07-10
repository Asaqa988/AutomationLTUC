package login;

import java.awt.Checkbox;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestcases {

	WebDriver driver = new ChromeDriver();
	String username ; 
	String TheLoginPassword = "Ahmad123!@#$";

	String TheURL = "https://automationteststore.com/";
	Random rand = new Random();

	@BeforeTest
	public void mySetup() {

		driver.get(TheURL);

		driver.manage().window().maximize();

	}

	@Test(priority = 1,enabled = true)

	public void SignUp() throws InterruptedException {

		driver.navigate().to("https://automationteststore.com/index.php?rt=account/create");

		// elements
		WebElement firstnameInput = driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
		WebElement lastNameInput = driver.findElement(By.id("AccountFrm_lastname"));
		WebElement emailInput = driver.findElement(By.id("AccountFrm_email"));
		WebElement teleInput = driver.findElement(By.id("AccountFrm_telephone"));
		WebElement faxInput = driver.findElement(By.id("AccountFrm_fax"));
		WebElement companyInput = driver.findElement(By.id("AccountFrm_company"));
		WebElement address1Input = driver.findElement(By.id("AccountFrm_address_1"));
		WebElement address2Input = driver.findElement(By.id("AccountFrm_address_2"));
		WebElement cityInput = driver.findElement(By.id("AccountFrm_city"));
		WebElement Country = driver.findElement(By.name("country_id"));
		WebElement state = driver.findElement(By.id("AccountFrm_zone_id"));
		WebElement postalCode = driver.findElement(By.id("AccountFrm_postcode"));
		WebElement LoginName = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement PasswordInput = driver.findElement(By.id("AccountFrm_password"));
		WebElement PasswordConfirmInput = driver.findElement(By.id("AccountFrm_confirm"));
		WebElement CheckBox = driver.findElement(By.id("AccountFrm_agree"));
		WebElement ContinueButton = driver.findElement(By.xpath("//button[@title='Continue']"))

		;

		// data

		int randomNumberForTheEmail = rand.nextInt(9800);

		String[] firstNames = { "anas", "mohammad", "omar", "ali" };
		int randomNameIndexForFirstNames = rand.nextInt(firstNames.length);

		String randomFirstName = firstNames[randomNameIndexForFirstNames];

		String[] lastNames = { "mohammad", "mahmoud", "khaleel", "abdullah", "anas" };

		int randomNameIndexForlastNames = rand.nextInt(lastNames.length);

		String randomLastName = lastNames[randomNameIndexForlastNames];

		String email = randomFirstName + randomLastName + randomNumberForTheEmail + "@gmail.com";

		String tele = "972837287383";
		String fax = "3293713";
		String company = "abc";
		String address1 = "add1";
		String address2 = "add2";
		String city = "city";

		// actions
		firstnameInput.sendKeys(randomFirstName);

		lastNameInput.sendKeys(randomLastName);
		emailInput.sendKeys(email);
		teleInput.sendKeys(tele);
		faxInput.sendKeys(fax);
		companyInput.sendKeys(company);
		address1Input.sendKeys(address1);
		address2Input.sendKeys(address2);
		cityInput.sendKeys(city);
		postalCode.sendKeys("1234");

		Thread.sleep(1000);

		Select myselectForcountry = new Select(Country);
		int randomCountry = rand.nextInt(1, 240);
		myselectForcountry.selectByIndex(randomCountry);

		Thread.sleep(1000);

		int numberofstates = state.findElements(By.tagName("option")).size();

		System.out.println(numberofstates);

		Select myselectForState = new Select(state);
		int randomState = rand.nextInt(1, numberofstates);
		myselectForState.selectByIndex(randomState);
		
		username=randomFirstName+randomLastName+randomNumberForTheEmail ; 
		LoginName.sendKeys(username);
		PasswordInput.sendKeys(TheLoginPassword);
		PasswordConfirmInput.sendKeys(TheLoginPassword); 
		
		CheckBox.click();
		ContinueButton.click();
		String myname = "ahmad";;
	}
	
	@Test(priority = 2,enabled = true)
	public void Logout() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement Logout = driver.findElement(By.linkText("Logoff"));
		
		Logout.click();
	}
	
	@Test(priority = 3)
	public void Login() {
		WebElement Loginorregister=driver.findElement(By.partialLinkText("Login or re"));
		Loginorregister.click();
		
		WebElement Login = driver.findElement(By.id("loginFrm_loginname"));
		WebElement password = driver.findElement(By.id("loginFrm_password"));
		
		Login.sendKeys(username);
		password.sendKeys(TheLoginPassword);

		driver.findElement(By.xpath("//button[@title='Login']")).click();
	}

}
