package curso_selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import junit.framework.Assert;

public class Desafios {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void init(){
		System.setProperty("webdriver.chrome.driver", "\\Users\\priscila.franca\\Downloads\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		System.getProperty("user.dir");
		dsl = new DSL(driver);
	}
	
	@After
	public void fim() {
		driver.quit();
	}
	
	@Test
	public void preencherForm() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Priscila");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Ribs");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select comboEsc = new Select(element);
		comboEsc.selectByIndex(6);
		WebElement elementEsp = driver.findElement(By.id("elementosForm:esportes"));
		Select comboEsp = new Select(elementEsp);
		comboEsp.selectByVisibleText("Corrida");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("namaste");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		//Corrigir os textos
		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		Assert.assertEquals("Nome: Priscila", driver.findElement(By.id("descNome")).getText().endsWith("Priscila"));
		Assert.assertEquals("Sobrenome: Ribs", driver.findElement(By.id("descSobrenome")).getText().endsWith("Ribs"));
		Assert.assertEquals("Sexo: Feminino", driver.findElement(By.id("descSexo")).getText().endsWith("Feminino"));
		Assert.assertEquals("Comida: Frango", driver.findElement(By.id("descComida")).getText().endsWith("Frango"));
		Assert.assertEquals("Escolaridade: mestrado", driver.findElement(By.id("descEscolaridade")).getText().endsWith("mestrado"));
		Assert.assertEquals("Esportes: Corrida", driver.findElement(By.id("descEsportes")).getText().endsWith("Corrida"));
		Assert.assertEquals("Sugestoes: namaste", driver.findElement(By.id("descSugestoes")).getText().endsWith("namaste"));
	}
	

	@Test
	public void testeFrame() {
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		Assert.assertEquals("Frame OK!", msg);
		alert.accept();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);
	}
	
	@Test
	public void testeWindow() {
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("");
		driver.findElement(By.tagName("textarea")).sendKeys("ok");
		driver.close();
	}
	
	@Test
	public void testeWindowSemTitulo() {
		driver.findElement(By.id("buttonPopUpEasy")).click();
		System.out.println(driver.getWindowHandles());
		System.out.println(driver.getWindowHandle());
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.tagName("textarea")).sendKeys("Foi?");
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.tagName("textarea")).sendKeys("Foi?");
	}
	
	@Test
	public void validarNomeObrigatorio() {
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		String textAlert = alert.getText();
		Assert.assertEquals("Nome eh obrigatorio", textAlert);
		alert.accept();
	}
	
	@Test
	public void validarSobrenomeObrigatorio() {
		dsl.escreve("elementosForm:nome", "Pri");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		String textAlert = alert.getText();
		Assert.assertEquals("Sobrenome eh obrigatorio", textAlert);
		alert.accept();
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
