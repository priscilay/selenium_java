package curso_selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCampoTreinamento {

	@Test
	public void testeTextField(){
		System.setProperty("webdriver.chrome.driver", "\\Users\\priscila.franca\\Downloads\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		System.getProperty("user.dir");
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Priscila");
		Assert.assertEquals("Prisila", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		//driver.quit();
	}
	
	@Test
	public void testeTextArea(){
		System.setProperty("webdriver.chrome.driver", "\\Users\\priscila.franca\\Downloads\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("65file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		System.getProperty("user.dir");
		
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Priscila");
		Assert.assertEquals("Prisila", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
		//driver.quit();
		
	}
	
}
