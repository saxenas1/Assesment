package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class WeatherPage extends BaseClass {

	public String getWeather() {
		String Weather = driver.findElement(By.xpath(OR.getProperty("Weather"))).getText();;		
		return Weather;
	}

	public String getCondition() {
		String Condition = driver
				.findElement(By.xpath(OR.getProperty("Condition"))).getText();
		return Condition;
	}
}
