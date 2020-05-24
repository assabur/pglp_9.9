package Formes;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import DAO.DaoCercle;
import fr.uvsq.solid.pglp_9.Flash;

public class CercleTest {

	private static Point centre;
	
	private static Cercle cercle;
	
	@Before public void setup()
	{
		centre= new Point(1,2);
		cercle=new Cercle("c1",centre,6);
	}
	@Test
	public void testCercle() 
	{
		
		Flash.affiche(cercle.toString());
	}

}
