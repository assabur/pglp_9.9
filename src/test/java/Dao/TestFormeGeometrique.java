package Dao;

import org.junit.Test;

import DAO.DaoFigureGeometrique;
import DessinException.BdException;
import DessinException.iOdessinException;
import Formes.FormeGeometrique;

public class TestFormeGeometrique {

	@Test
	public void testFormeGeometrique() throws BdException, iOdessinException
	{
		System.out.println(DaoFigureGeometrique.read("c1").toString());
	}
}
