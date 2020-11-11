package com.testCase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MynthraTest {

	WebDriver driver;
	Actions action;

	
	@Parameters("browser")
	@Test
	public void meth(String browser) throws InterruptedException {
         
		
		if(browser.equalsIgnoreCase("chrome")) {
			
		
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--disable-notifications");
		options.addArguments("headless");
           
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		}
		else {
			System.setProperty("webdriver.gecko.driver", "G:\\selenium\\mynthra\\driver\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.linkText("MEN"))).build().perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.linkText("T-Shirts"))).click().build().perform();
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//div[@class='atsa-base']/ul/li[2]")).click();
		List<WebElement> size = driver.findElements(By.cssSelector(
				"[class='atsa-base'] [class='atsa-atsaFiltersOptionCtn atsa-atsaShowContainer'] ul li label"));

		for (WebElement ele : size) {
			String sizes = ele.getText();

			if (sizes.equalsIgnoreCase("l")) {
				ele.click();
				break;
			}
		}
		Thread.sleep(2000);

		
		action.moveToElement(driver
				.findElement(By.xpath("//section/div/div[@class='horizontal-filters-sortContainer']")))
				.build().perform();
		List<WebElement> sorting = driver.findElements(By.cssSelector("div[class='sort-sortBy'] ul li label"));

		for (WebElement sort : sorting) {
			String type = sort.getText();

			if (type.equalsIgnoreCase("Popularity")) {
				sort.click();
				break;
			}
		}
		Thread.sleep(2000);
		
		
		List<WebElement> brands = driver.findElements(By.xpath("//section/div[1]/div[3]/ul/li/label"));

		for (WebElement brand : brands) {
			String name = brand.getText();

			if (name.contains("Puma")) {
				brand.click();
				break;
			}
		}
		Thread.sleep(3000);
	
		
		List<WebElement> colors = driver.findElements(By.xpath("//section/div[1]/div[5]/ul/li/label"));

		for (WebElement color : colors) {
			String nameOfColor = color.getText();

			if (nameOfColor.contains("Red")) {
				color.click();
				break;
			}
		}

	}

}
