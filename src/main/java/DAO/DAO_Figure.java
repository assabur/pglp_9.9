package DAO;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
;



/*
 * classe DAO du projet
 */
public abstract class DAO_Figure <T> {
	
	
	  public String nomBd;
	  public static Connection conn =ConnectionDerby.connection();
	  /*
	   * je definis l'ensemble des requetes preparés
	   */
	  protected PreparedStatement psInsert;
	  protected PreparedStatement psUpdate;
	  protected PreparedStatement psSelect;
	  protected ResultSet rs = null;
	  protected static final String SQL_SERIALIZE_OBJECT = "INSERT INTO forme(nom, objet) VALUES (?,?)";
	  protected static final String SQL_DESERIALIZE_OBJECT = "SELECT * FROM forme WHERE nom = ?";
	  protected static final String SQL_UPDATE_OBJECT = "UPDATE forme set objet = ?  WHERE nom = ?";
	  protected static final String SQL_DELETE_OBJECT = "DELETE FROM forme WHERE nom = ?";
	 
	  public DAO_Figure(Connection connect)	
	  {
			this.conn=connect;
	  }
	
	public abstract boolean create(T obj);
	public abstract T read(Object monObjet);
	public abstract boolean update(T obj);
	public abstract boolean delete(String name);


}
