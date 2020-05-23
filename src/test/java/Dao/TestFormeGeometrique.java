package Dao;

import org.junit.Test;

import DAO.DaoFigureGeometrique;
import Formes.FormeGeometrique;

public class TestFormeGeometrique {

	@Test
	public void testFormeGeometrique()
	{
		System.out.println(DaoFigureGeometrique.read("c1").toString());
	}
}
