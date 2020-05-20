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
	private static String JDBC_URL="jdbc:derby:DessinDB;create=true";
	private static final String DRIVER="org.apache.derby.jdbc.EmbeddedDriver";
	private static Statement statement;
	//connect 'jdbc:derby:DessinDB;create=true';
	
	/*
	 * methode permettant de se connecter directemeent à la base de données
	 */
	public static  Connection  connection() 
	{
		Connection conn=null;
		try {
			Class.forName(DRIVER);			
			conn=DriverManager.getConnection(JDBC_URL);
			//statement = conn.createStatement();	
			//statement.execute("create table forme(nom varchar(20), objet BLOB)");
		}
		catch(SQLException e)
		{
			Flash.affiche("erreur de connection a la BD ");
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			Flash.affiche(e.getMessage());
			Flash.affiche("ERREUR : charger derby.jdbc.EmbeddedDriver ");	       
	    }
		finally
		{
			 
		}	
		return conn;
	}
	
}
