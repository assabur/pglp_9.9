package fr.uvsq.solid.pglp_9;

import org.junit.Before;
import org.junit.Test;

import DAO.ConnectionDerby;

public class BdConnexionTest {
	
	@Before
	public void setup()
	{
			
	}
	@Test
	public void test_connexion()
	{	
		ConnectionDerby.connection();
	}

}
