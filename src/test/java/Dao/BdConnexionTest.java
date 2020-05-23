package Dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import DAO.ConnectionDerby;
import DAO.DaoFActory;

public class BdConnexionTest {

	@Test
	public void test_connexion() throws SQLException
	{	
		Connection conn=ConnectionDerby.connection();
		if(ConnectionDerby.CreationTableForme())
			{
				System.out.println("creation de table reuissi");
			}
	}
}
