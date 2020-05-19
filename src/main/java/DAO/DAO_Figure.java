package DAO;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
;



/*
 * classe DAO du projet
 */
public abstract class DAO_Figure <T> {
	
	protected Connection connect;
	 public String nomBd;
	  public static Connection conn = null;
	  ArrayList<Statement> statements = new ArrayList<Statement>();
	  /*
	   * je definis l'ensemble des requetes preparés
	   */
	  protected PreparedStatement psInsert;
	  protected PreparedStatement psUpdate;
	  protected PreparedStatement psSelect;
	  protected ResultSet rs = null;
	  protected static final String SQL_SERIALIZE_OBJECT = "INSERT INTO DessinDB(nom, objet) VALUES (?,?)";
	  protected static final String SQL_DESERIALIZE_OBJECT = "SELECT * FROM DessinDB WHERE nom = ?";
	  protected static final String SQL_UPDATE_OBJECT = "UPDATE DessinDB set objet = ?  WHERE nom = ?";
	  protected static final String SQL_DELETE_OBJECT = "DELETE FROM DessinDB WHERE nom = ?";
	  public DAO_Figure(Connection connect)
		
	  {
			this.connect=connect;
	  }
	
	public abstract boolean create(T obj);
	public abstract T read(String name);
	public abstract boolean update(T obj);
	public abstract boolean delete(String name);


}
