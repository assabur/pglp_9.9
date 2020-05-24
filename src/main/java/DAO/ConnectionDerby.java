package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import fr.uvsq.solid.pglp_9.Flash;

public class ConnectionDerby {

	/*
	 * definition des constantes de connexion
	 */
	private static String JDBC_URL="jdbc:derby:FormeDB;create=true";
	
	//private static String JDBC_DOWN="jdbc:derby:FormeDB;shutdown=true";

	//private static String JDBC_URL="jdbc:derby://localhost:1527/FormeDB";
	private static final String DRIVER="org.apache.derby.jdbc.EmbeddedDriver";
	private static Statement statement;

	/*
	 * methode permettant de se connecter directemeent à la base de données
	 */

	//DriverManager.getConnection("jdbc:derby:FormeDB;shutdown=true");
	public static Connection connection() 
	{
		Connection connec;
		try {
			// connec =DriverManager.getConnection(JDBC_DOWN);
			connec =DriverManager.getConnection(JDBC_URL);
			if (connec!=null)
				//Flash.affiche("connection reuissi");
				return connec;
		} catch (SQLException e )
		{

			//e.printStackTrace();
			Flash.affiche("echec de connexion à la BD reesayer");
		}

		return null;
	}
	public static boolean CreationTableForme() {
		Statement statement;
		try {

			Connection db = ConnectionDerby.connection();	

			statement = db.createStatement();	

			statement.execute("create table forme(nom varchar(20), objet BLOB)");

			statement.close();
			return true;

		} catch (SQLException e) {
			return false;
		}	
	}

}
