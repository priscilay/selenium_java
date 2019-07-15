package curso_selenium;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class TesteRegrasCadastro {

	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	@Parameter
	public String nome;
	@Parameter(value=1)
	public String sobrenome;
	@Parameter(value=2)
	public String sexo;
	@Parameter(value=3)
	public List<String> comidas;
	@Parameter(value=4)
	public String[] esportes;
	@Parameter(value=5)
	public String msg;
	

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
	public void finaliza(){
		driver.quit();
	}
	
	@Parameters
	public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object[][] {
			{"", "", "", Arrays.asList(), new String[]{}, "Nome eh obrigatorio"},
			{"Pris", "", "", Arrays.asList(), new String[]{}, "Sobrenome eh obrigatorio"},
			{"Pri", "Rib", "", Arrays.asList(), new String[]{}, "Sexo eh obrigatorio"},
			{"Pri", "Rib", "Feminino", Arrays.asList("Vegetariano", "Carne"), new String[]{}, "Tem certeza que voce eh vegetariano?"},
			{"Pri", "Rib", "Feminino", Arrays.asList("Pizza"), new String[]{"Corrida", "O que eh esporte?"}, "Voce faz esporte ou nao?"}
		});
	}
	
	@Test
	public void validarRegras(){
		page.setNome(nome);
		page.setSobrenome(sobrenome);
		if(sexo.equals("Feminino")) {
			page.generoFeminino();
		} 
		if(sexo.equals("Masculino")) {
			page.generoMasculino();
		}
		if(comidas.contains("Carne")) page.comidaCarne();; 
		if(comidas.contains("Pizza")) page.comidaPizza();
		if(comidas.contains("Vegetariano")) page.comidaVegan();
		page.setEsportes(esportes);
		page.cadastrar();
		System.out.println(msg);
		Assert.assertEquals(msg, dsl.msgAlertAcept());
	}
}
