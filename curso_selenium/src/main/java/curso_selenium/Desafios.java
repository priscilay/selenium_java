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

import junit.framework.Assert;

public class Desafios {
	
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
	public void preencherForm() {
		page.setNome("Priscila");
		page.setSobrenome("Ribs");
		page.generoFeminino();
		page.comidaVegan();
		page.setEsportes("Corrida");
		page.setEscolaridade("Mestrado");		
		page.setSugestoes("Namaste");
		page.cadastrar();
		Assert.assertTrue(page.obterNomeCadastro().endsWith("Priscila"));
		Assert.assertEquals("Sobrenome: Ribs", page.obterSobrenomeCadastro());
		Assert.assertEquals("Sexo: Feminino", page.obterSexoCadastro());
		Assert.assertEquals("Comida: Vegetariano", page.obterComidaCadastro());
		Assert.assertEquals("Escolaridade: mestrado", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Esportes: Corrida", page.obterEsportesCadastro());
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
		dsl.clicar("buttonPopUpEasy");
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
		WebElement frame = driver.findElement(By.id("frame2"));
		dsl.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
		dsl.entrarFrame("frame2");
		dsl.clicar("frameButton");
		String msg = dsl.msgAlertAcept();
		Assert.assertEquals("Frame OK!", msg);
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
