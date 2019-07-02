package victor.clientes.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


import victor.clientes.modelo.ClienteVO;
import victor.clientes.modelo.dao.IClienteVODAO;



@RunWith(SpringRunner.class)
@DataJpaTest
public class Inserciontest {

	@Autowired
	TestEntityManager entityManager;
	@Autowired
	IClienteVODAO dao;
	
	
	@Before
	public void setUp() throws Exception {
		
		ClienteVO cliente = new ClienteVO("1111111-1","vito","merino" , "vito@blabla", "13245678");
		this.entityManager.persist(cliente);
		cliente = new ClienteVO("2222222-2","monica","norambuena","monica@blalba","5468798");
		
		this.entityManager.persist(cliente);
		cliente = new ClienteVO("3333333-3","saul","figueroa","saul@blalba","5464398");
		this.entityManager.persist(cliente);
		
		cliente = new ClienteVO("4444444-4","bastina","carso","basti@blalba","1268798");
		this.entityManager.persist(cliente);
	
		cliente = new ClienteVO("5555555-5","pedro","pack","pedro@blalba","6468798");
		this.entityManager.persist(cliente);
		
		
		
		
	}

	
	@Test
	public void cuandoInserta1entonces6equipos() {
		this.dao.save(new ClienteVO("6666666-6","ELNUEVO","NUEVO","NUEVO@blalba","1456398"));
		int largo = this.dao.findAll().size();
		assertTrue("SON" + largo + "PERO DEBERIAN SER 6 ", largo == 6);
	}
	
	
	
	
	
	

}
