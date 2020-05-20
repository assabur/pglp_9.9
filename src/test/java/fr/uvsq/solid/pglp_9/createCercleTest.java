package fr.uvsq.solid.pglp_9;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import DAO.ConnectionDerby;
import DAO.DaoCercle;
import Formes.Cercle;
import Formes.Point;


public class createCercleTest {
	
	private static Point centre= new Point(1,2);
	private static Cercle cercle=new Cercle("c1",centre,6);
	@Test
	public void testCercle() throws SQLException
	{
		Connection conn=ConnectionDerby.connection();
		DaoCercle daocercle=new DaoCercle(conn);
		if(daocercle.create(cercle))
		Flash.affiche("forme creer");
		//daocercle.read("c1").toString();
	}
}
