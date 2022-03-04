import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

public class Question2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// Initializing Chrome Browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dell\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Hitting the url
		String url = "https://jt-dev.azurewebsites.net/#/SignUp";
		driver.get(url);
		Thread.sleep(2000);

		// Checking if "English" and "Dutch" present in the dropdown
		WebElement language = driver.findElement(By.xpath("//*[@id=\"language\"]/input[1]"));
		Select lang = new Select(language);
		List<WebElement> options = lang.getOptions();

		// List of actual dropdown values
		List<String> optionString = new ArrayList<String>();
		for (WebElement option : options) {
			optionString.add(option.getText().toString());
		}

		// List of expected values in dropdown
		List<String> expectedLang = new ArrayList<String>();
		expectedLang.add("English");
		expectedLang.add("Dutch");

		// comparing both the actual and the expected list
		Boolean value = expectedLang.containsAll(optionString);

		// if present then printing a message indicating that both are present
		if (value == true) {
			System.out.println("Both 'English' and 'Dutch' are present in the dropdown");
		}

		// name
		driver.findElement(By.id("name")).sendKeys("Neelam Ubhe");

		// organization name
		driver.findElement(By.id("orgName")).sendKeys("Neelam Ubhe");

		// email address
		driver.findElement(By.id("singUpEmail")).sendKeys("neelamubhe1734@gmail.com");

		// checking checkbox for terms and copnditions
		driver.findElement(By.cssSelector("span.black-color.ng-binding::before")).click();

		// clicking on signup
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/section/div[1]/form/fieldset/div[5]/button"))
				.click();

		// validating received mail or not
		String text = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/section/div[1]/form/div/span"))
				.getText();
		Assert.assertEquals("A welcome email has been sent. Please check your email.", text);
	}

}
