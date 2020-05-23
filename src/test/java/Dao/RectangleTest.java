package Dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import DAO.ConnectionDerby;
import DAO.DaoCercle;
import DAO.DaoRectangle;
import Formes.Point;
import Formes.Rectangle;
import fr.uvsq.solid.pglp_9.Flash;

public class RectangleTest {

	private static Point upLeft= new Point(1,2);
	private static Point upRight= new Point(1,2);
	private Rectangle rectangle=new Rectangle("rect1",upLeft,upRight);
	@Test
	public void testRectangle() throws SQLException
	{
		Connection conn=ConnectionDerby.connection();
		DaoRectangle daoRect=new DaoRectangle(conn);
		if(daoRect.create(rectangle))
		Flash.affiche("forme creer");
		//daocercle.read("c1").toString();
	}
}
