package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import fr.uvsq.solid.pglp_9.Flash;

public class CreateTableForme {
	
	public static void CreationTableForme() {
		Statement statement;
		try {
			 //System.out.println("avant create1");
			  Connection db = ConnectionDerby.connection();	
			  //System.out.println("avant create2");
			  statement = db.createStatement();	
			  //System.out.println("avant create");
		      /*statement.execute("if not exists (select * from sysobjects where name='forme' and"
		      		+ "xtype='U'"
		      		+ "create table forme(nom varchar(20), objet BLOB)");
			  */
			  
			  statement.execute("create table forme(nom varchar(20), objet BLOB)");
			  //System.out.println("apres create");
			
			  /*		
			 * if not exists (select * from sysobjects where name='forme' and
			 * xtype='U') create table etc( ID BIGINT PRIMARY KEY, title
			 * VARCHAR(150) );
			 */
		      statement.close();
			  Flash.affiche("table creee avec succes");

		} catch (SQLException e) {
			Flash.affiche("creation de table non valide");
			//e.printStackTrace();
		}
	}
}
