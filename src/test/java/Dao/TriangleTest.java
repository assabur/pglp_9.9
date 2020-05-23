package Dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import DAO.ConnectionDerby;
import DAO.DaoTriangle;
import Formes.Point;
import Formes.Triangle;
import fr.uvsq.solid.pglp_9.Flash;

public class TriangleTest {

	private static Point p1= new Point(1,2);
	private static Point p2= new Point(4,2);
	private static Point p3= new Point(5,2);
	private Triangle trig=new Triangle("trig1",p1,p2,p3);
	@Test
	public void testRectangle() throws SQLException
	{
		Connection conn=ConnectionDerby.connection();
		DaoTriangle daoTrig=new DaoTriangle(conn);
		if(daoTrig.create(trig))
		Flash.affiche("forme creer");	
	}

}
