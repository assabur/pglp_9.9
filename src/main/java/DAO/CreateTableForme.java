package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import fr.uvsq.solid.pglp_9.Flash;

public class CreateTableForme {
	
	public static void CreationTableForme() {
		Statement statement;
		try {
			  Connection db = ConnectionDerby.connection();	
			  statement = db.createStatement();	
			  statement.execute("create table forme(nom varchar(20), objet BLOB)");

		      statement.close();
			  Flash.affiche("table creee avec succes");

		} catch (SQLException e) {
			Flash.affiche("creation de table non valide");
		}
	}
}
