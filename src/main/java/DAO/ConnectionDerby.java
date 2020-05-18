package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.uvsq.solid.pglp_9.Flash;

public class ConnectionDerby {
	
	/*
	 * definition des constantes de connexion
	 */
	private static String JDBC_URL="jdbc:derby:DessinDB;create=true";
	private static final String DRIVER="org.apache.derby.jdbc.EmbeddedDriver";

	/*
	 * methode permettant de se connecter directemeent à la base de données
	 */
	public static  Connection  connection()
	{
		Connection conn=null;
		try {
			
			Class.forName(DRIVER);			
			conn=DriverManager.getConnection(JDBC_URL);
		/*	if (conn!=null)
			{
				Flash.affiche("connexion au serveur de Bd reuissi");
			}*/
		} catch (SQLException e )
		{
			Flash.affiche("echec de connexion");
		}
		catch (ClassNotFoundException e) 
		{
			//System.out.println();
			Flash.affiche(e.getMessage());
			Flash.affiche("ERREUR : charger derby.jdbc.EmbeddedDriver ");	       
	    }
		return conn;
	}		

}
