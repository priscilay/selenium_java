package test;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import core.DSL;
import core.DriverFactory;
import junit.framework.Assert;
import page.CampoTreinamentoPage;

public class TesteAlert {
	
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	@Before
	public void init(){
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
		page = new CampoTreinamentoPage();
		}
	
	@After
	public void fim() {
		killDriver();
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
