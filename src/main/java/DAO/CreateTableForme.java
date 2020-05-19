package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import fr.uvsq.solid.pglp_9.Flash;

public class CreateTableForme {
	private static Statement statement;
	public CreateTableForme() {
		try {
			  Connection db = ConnectionDerby.connection();		
			  statement = db.createStatement();		      
		      statement.execute("create table forme(nom varchar(20), objet BLOB)");
			/*
			 * if not exists (select * from sysobjects where name='forme' and
			 * xtype='U') create table etc( ID BIGINT PRIMARY KEY, title
			 * VARCHAR(150) );
			 */
				Flash.affiche("table creee avec succes");

		} catch (SQLException e) {

		}
	}
}
