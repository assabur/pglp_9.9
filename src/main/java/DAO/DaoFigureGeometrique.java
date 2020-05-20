package DAO;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import Formes.Carre;
import Formes.Cercle;
import Formes.CompositeFigure;
import Formes.FormeGeometrique;
import Formes.Rectangle;
import Formes.Triangle;

/*
 * classe qui recupere un objet ( de type formeGeometrique) dans la bD
 */
public class DaoFigureGeometrique  {

	  public static Connection conn =ConnectionDerby.connection();
	  /*
	   * je definis l'ensemble des requetes preparés
	   */

	  protected static PreparedStatement psSelect;
	  protected ResultSet rs = null;
	  protected static final String SQL_SERIALIZE_OBJECT = "INSERT INTO forme(nom, objet) VALUES (?,?)";
	  protected static final String SQL_DESERIALIZE_OBJECT = "SELECT * FROM forme WHERE nom = ?";
	  protected static final String SQL_UPDATE_OBJECT = "UPDATE forme set objet = ?  WHERE nom = ?";
	  protected static final String SQL_DELETE_OBJECT = "DELETE FROM forme WHERE nom = ?";
	 /*
	  * methode qui verifie l'instance d'un objet stocké dans la BD 
	  */
	  
	  private static HashMap<String,Object> elmt=new HashMap<>();
	  
	  public static HashMap<String,Object> read (String nom) {
		  try {
		  		psSelect = conn
			        .prepareStatement(SQL_DESERIALIZE_OBJECT);
			    psSelect.setString(1, nom);
			    ResultSet rs = psSelect.executeQuery();
			    rs.next();

			    byte[] b = rs.getBytes(2);
			    ByteArrayInputStream is = new ByteArrayInputStream(b);
			    ObjectInputStream ois = new ObjectInputStream(is);	
			    Object monObjet=ois.readObject();
			    if (monObjet instanceof Cercle)
			    {
			    	elmt.put("cercle", monObjet);
			    	return elmt;			    	 			    	
			    }
			    if (monObjet instanceof Triangle)
			    {
			    	elmt.put("triangle", monObjet);
			    	return elmt;			    	 			    	
			    }
			    if (monObjet instanceof Carre)
			    {
			    	elmt.put("carre", monObjet);
			    	return elmt;			    	 			    	
			    }
			    if (monObjet instanceof Rectangle)
			    {
			    	elmt.put("rectangle", monObjet);
			    	return elmt;			    	 			    	
			    }
			    if (monObjet instanceof CompositeFigure)
			    {
			    	elmt.put("composite", monObjet);
			    	return elmt;			    	 			    	
			    }
			    rs.close();
			    is.close();
			    ois.close();
			    psSelect.close();
	} catch (Exception e) {
		
	}
		return null;
	}
}
