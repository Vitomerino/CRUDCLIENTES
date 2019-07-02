package victor.clientes.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Eliminaciontest.class, Inserciontest.class, Listartest.class, Modificaciontest.class,
		Obtenerunotest.class })
public class AllTests {

}
