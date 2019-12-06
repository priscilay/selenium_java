package test;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.BaseTest;
import core.DSL;
import junit.framework.Assert;
import page.CampoTreinamentoPage;

public class Desafios extends BaseTest{
	
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	@Before
	public void init(){
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
		page = new CampoTreinamentoPage();
	}
	

	@Test
	public void preencherForm() {
		page.setNome("Priscila");
		page.setSobrenome("Ribs");
		page.generoFeminino();
		page.comidaVegan();
		page.setEsportes("Corrida");
		page.setEscolaridade("Mestrado");		
		page.setSugestoes("Namaste");
		page.cadastrar();
		Assert.assertEquals("Priscila",page.obterNomeCadastro());
		Assert.assertEquals("Ribs", page.obterSobrenomeCadastro());
		Assert.assertEquals("Feminino", page.obterSexoCadastro());
		Assert.assertEquals("Vegetariano", page.obterComidaCadastro());
		Assert.assertEquals("mestrado", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Corrida", page.obterEsportesCadastro());
	}
	

	@Test
	public void testeFrame() {
		getDriver().switchTo().frame("frame1");
		getDriver().findElement(By.id("frameButton")).click();
		Alert alert = getDriver().switchTo().alert();
		String msg = alert.getText();
		Assert.assertEquals("Frame OK!", msg);
		alert.accept();
		getDriver().switchTo().defaultContent();
		getDriver().findElement(By.id("elementosForm:nome")).sendKeys(msg);
	}
	
	@Test
	public void testeWindow() {
		dsl.clicar("buttonPopUpEasy");
		getDriver().switchTo().window("");
		getDriver().findElement(By.tagName("textarea")).sendKeys("ok");
		getDriver().close();
	}
	
	@Test
	public void testeWindowSemTitulo() {
		getDriver().findElement(By.id("buttonPopUpEasy")).click();
		System.out.println(getDriver().getWindowHandles());
		System.out.println(getDriver().getWindowHandle());
		getDriver().switchTo().window((String)getDriver().getWindowHandles().toArray()[0]);
		getDriver().findElement(By.tagName("textarea")).sendKeys("Foi?");
		getDriver().switchTo().window((String)getDriver().getWindowHandles().toArray()[1]);
		getDriver().findElement(By.tagName("textarea")).sendKeys("Foi?");
	}
	
	@Test
	public void validarNomeObrigatorio() {
		page.cadastrar();
		Assert.assertEquals("Nome eh obrigatorio", dsl.msgAlertAcept());
	}
	
	@Test
	public void validarSobrenomeObrigatorio() {
		dsl.escrever("elementosForm:nome", "Pri");
		dsl.clicar("elementosForm:cadastrar");
		Assert.assertEquals("Sobrenome eh obrigatorio", dsl.msgAlertAcept());
	}
	
	@Test
	public void frameEscondido(){
		WebElement frame = getDriver().findElement(By.id("frame2"));
		dsl.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
		dsl.entrarFrame("frame2");
		dsl.clicar("frameButton");
		String msg = dsl.msgAlertAcept();
		Assert.assertEquals("Frame OK!", msg);
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
