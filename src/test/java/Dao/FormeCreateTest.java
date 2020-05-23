package Dao;

import java.sql.SQLException;

import org.junit.Test;

import DAO.CreateTableForme;


public class FormeCreateTest  {
	
	@Test
	public void create_test() throws SQLException
	{	
		CreateTableForme.CreationTableForme();	
	}
}
