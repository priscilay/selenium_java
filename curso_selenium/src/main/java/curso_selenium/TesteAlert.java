package curso_selenium;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class TesteAlert {

	@Test
	public void clicarAlerta() {
		System.setProperty("webdriver.chrome.driver", "\\Users\\priscila.franca\\Downloads\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		System.getProperty("user.dir");
		WebElement botaoAlert = driver.findElement(By.id("alert"));
		botaoAlert.click();
		Alert alert =  driver.switchTo().alert();
		String textAlert = alert.getText();
		Assert.assertEquals("Alert Simples", textAlert);
		alert.accept();
		WebElement textName = driver.findElement(By.id("elementosForm:nome"));
		textName.sendKeys(textAlert);
		//Assert.assertEquals("Alert Simples", )
		driver.quit();
	}
	
	@Test
	public void clicarAlertaConfirm() {
		System.setProperty("webdriver.chrome.driver", "\\Users\\priscila.franca\\Downloads\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		System.getProperty("user.dir");
		WebElement botaoAlertConfirm = driver.findElement(By.id("confirm"));
		botaoAlertConfirm.click();
		Alert alertCconfirm = driver.switchTo().alert();
		alertCconfirm.dismiss();
		Assert.assertEquals("Negado", alertCconfirm.getText());
		alertCconfirm.accept();
		driver.quit();	
	}
	
	@Test
	public void clicarAlertaPrompt() {
		System.setProperty("webdriver.chrome.driver", "\\Users\\priscila.franca\\Downloads\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		System.getProperty("user.dir");
		WebElement botaoAlertPrompt = driver.findElement(By.id("prompt"));
		botaoAlertPrompt.click();
		Alert alertPrompt = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alertPrompt.getText());
		alertPrompt.sendKeys("1111");
		alertPrompt.accept();
		Assert.assertEquals("Era 1111?", alertPrompt.getText());
		alertPrompt.accept();
		Assert.assertEquals(":D", alertPrompt.getText());
		driver.quit();	
	}
}
