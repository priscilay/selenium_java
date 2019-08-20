package curso_selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class TesteAlert {
	
	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	@Before
	public void init(){
		System.setProperty("webdriver.chrome.driver", "\\Users\\priscila.franca\\Downloads\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		System.getProperty("user.dir");
		dsl = new DSL(driver);
		page = new CampoTreinamentoPage(driver);
		}
	
	@After
	public void fim() {
		driver.quit();
	}
	

	@Test
	public void clicarAlerta() {
		dsl.clicar("alert");
		String textAlert = dsl.msgAlert();
		Assert.assertEquals("Alert Simples", textAlert);
		dsl.okAlert();
		page.setNome(textAlert);
	}
	
	@Test
	public void clicarAlertaConfirm() {
		dsl.clicar("confirm");
		dsl.confirmAlert();
		String text = dsl.msgAlert();
		Assert.assertEquals("Negado", text);
		dsl.okAlert();
	}
	
	@Test
	public void clicarAlertaPrompt() {
		dsl.clicar("prompt");
		String text = dsl.msgAlert();
		Assert.assertEquals("Digite um numero", text);
		dsl.escreverAlert("1111");
		dsl.okAlert();
		String text2 = dsl.msgAlert();
		Assert.assertEquals("Era 1111?", text2);
		dsl.okAlert();
		String text3 = dsl.msgAlert();
		Assert.assertEquals(":D", text3);
		dsl.okAlert();
	}
}
