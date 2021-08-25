package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class LandingPage extends BaseClass {

	public void navigateToWeather() {

		try {
			driver.findElement(By.xpath(OR.getProperty("AllSectionsTab"))).click();
			driver.findElements(By.xpath(OR.getProperty("WeatherTab"))).get(1).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void navigateToHeadline() {
		driver.findElement(By.xpath(OR.getProperty("HeadlineMainPage"))).click();
	}

	public String navigateToSingapore() {
		driver.findElement(By.xpath(OR.getProperty("SingaporeTab"))).click();
		String Headline = driver.findElement(By.xpath(OR.getProperty("Headline"))).getText();
		return Headline;
	}

}
