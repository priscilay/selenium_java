package suites;

import static core.DriverFactory.killDriver;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.TesteCampoTreinamento;
import test.TesteRegrasCadastro;

@RunWith(Suite.class)
@SuiteClasses({
	//Desafios.class,
	TesteRegrasCadastro.class,
	TesteCampoTreinamento.class
})
public class RunTests {
	
	@AfterClass
	public static void finalizaTudo(){
		killDriver();
	}
	
}
