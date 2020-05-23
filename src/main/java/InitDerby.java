import fr.uvsq.solid.pglp_9.Flash;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;


	public abstract class InitDerby {
				
		  static Connection conn = null;
		  static ArrayList<Statement> statements = new ArrayList<Statement>();
		  static Statement s;
		  static String Bdname;
		  public static Connection connection(){
		    Properties props = new Properties(); // connection properties
		    props.put("user", "user");
		    props.put("password", "user");
		    Bdname = "dessinDb";
		    try {
		      conn = DriverManager.getConnection("jdbc:derby:" + Bdname
		          + ";create=true", props);
		      s = conn.createStatement();
		      statements.add(s);

		    } catch (SQLException e) {
		      Flash.affiche("Erreur de connexion à la BD");
		      e.printStackTrace();
		    }
		    return conn;
		  }

		  public static void createTables() throws SQLException {
		    try {
		      s.execute("create table forme(id varchar(20)," +
		          " objet BLOB)");
		    } catch (SQLException e) {
		      if(Helper.tableExist(e)) {
		        return;
		      }
		      throw e;
		    }

		  }

		}

