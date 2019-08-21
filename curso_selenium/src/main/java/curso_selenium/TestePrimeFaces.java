package curso_selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestePrimeFaces {
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void init(){
		System.setProperty("webdriver.chrome.driver", "\\Users\\priscila.franca\\Downloads\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		System.getProperty("user.dir");
		dsl = new DSL(driver);
		}
	
	@After
	public void fim() {
		driver.quit();
	}
	
	@Test
	public void radioPrime() {
		driver.get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		dsl.clicarRadio(By.xpath("//input[@id='j_idt701:console:0']/../..//span"));
		Assert.assertTrue(dsl.radioMarcado("j_idt701:console:0"));
		dsl.clicarRadio(By.xpath(".//label[.='PS4']/..//span"));
		Assert.assertTrue(dsl.radioMarcado("j_idt701:console:1"));
	}
	
	@Test
	public void selectPrime() {
		driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl.selecionarComboPrime("j_idt701:console", "PS4");
		String text = dsl.obterTexto("j_idt701:console_label");
		Assert.assertEquals("PS4", text);
	}
	
	@Test
	public void testeXpath() {
		//site teste http://www.juliodelima.com.br/taskit/
		dsl.clicarRadio(By.xpath(".//div/div/ul/li/a[@class='modal-trigger'][1][contains(text(),'Sign in')]['2']"));
		dsl.clicarRadio(By.xpath(".//div/a[@class='modal-action waves-effect waves-green btn-flat'][contains(text(),'Sign in')]"));
	}
}
