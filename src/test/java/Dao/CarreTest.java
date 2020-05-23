package Dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import DAO.ConnectionDerby;
import DAO.DaoCarre;
import DAO.DaoRectangle;
import Formes.Carre;
import Formes.Point;
import Formes.Rectangle;
import fr.uvsq.solid.pglp_9.Flash;

public class CarreTest {

	private static Point upLeft= new Point(1,2);
	private static int cote= 5;
	private Carre carre=new Carre("carre1",upLeft,cote);
	@Test
	public void testCarre() throws SQLException
	{
		Connection conn=ConnectionDerby.connection();
		DaoCarre daoCarre=new DaoCarre(conn);
		if(daoCarre.create(carre))
		Flash.affiche("forme creer");	
	}
}
