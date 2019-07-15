package curso_selenium;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	Desafios.class,
	TesteRegrasCadastro.class,
	TesteCampoTreinamento.class
})
public class RunTests {
	
}
