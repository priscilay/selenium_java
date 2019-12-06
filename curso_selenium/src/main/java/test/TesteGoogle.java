package test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {

	@Test
	public void teste() {
		// caso nao estivesse configurado a variavel de ambiente para
		// chromedriver
		System.setProperty("webdriver.chrome.driver", "\\Users\\priscila.franca\\Downloads\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//distnacia navegador
		driver.manage().window().setPosition(new Point(100, 100));
		
		//tamanho navegador
		driver.manage().window().setSize(new Dimension(1200, 765));
		
		//maximizar
		driver.manage().window().maximize();
		
		//abrindo a aplicacao
		driver.get("https://www.google.com.br");
		
		//validando titulo
		String tituloObtido = driver.getTitle();
		Assert.assertEquals("Google", tituloObtido);
		
		//fechando navegador 
		driver.quit();

	}

}
