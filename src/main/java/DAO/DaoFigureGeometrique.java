package DAO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import DessinException.BdException;
import DessinException.iOdessinException;
import Formes.Carre;
import Formes.Cercle;
import Formes.CompositeFigure;
import Formes.FormeGeometrique;
import Formes.Rectangle;
import Formes.Triangle;
import fr.uvsq.solid.pglp_9.Flash;

/*
 * classe qui recupere un objet ( de type formeGeometrique) dans la bD
 */
public class DaoFigureGeometrique  {


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

	//private static HashMap<String,Object> elmt=new HashMap<>();

	public static Object read (String nom) throws BdException, iOdessinException   {
		try {
			psSelect = ConnectionDerby.connection()
					.prepareStatement(SQL_DESERIALIZE_OBJECT);
			psSelect.setString(1, nom);
			ResultSet rs = psSelect.executeQuery();
			rs.next();
			byte[] b = rs.getBytes(2);
			ByteArrayInputStream is = new ByteArrayInputStream(b);
			ObjectInputStream ois = new ObjectInputStream(is);	
			Object monObjet=ois.readObject();		    
			rs.close();
			is.close();
			ois.close();
			psSelect.close();
			return monObjet;

		} catch (SQLException e) {

			Flash.affiche("Acces refusé Tapez Help pour l'aide");
		}
		catch (IOException e) {
			Flash.affiche("erreur IO");
		}
		catch (ClassNotFoundException e) {
			Flash.affiche("erreur IO");
		}
		return null;
	}

	public static boolean update(FormeGeometrique obj,String name)
	{
		PreparedStatement psUpdate;
		try 
		{
			
			Connection conn=ConnectionDerby.connection();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(out);
			os.writeObject(obj);
			
			byte[] b = out.toByteArray();
			ByteArrayInputStream objectIn = new ByteArrayInputStream(b);
			psUpdate = conn.prepareStatement(
					SQL_UPDATE_OBJECT);
			
			psUpdate.setBinaryStream(1, objectIn, b.length);
			psUpdate.setString(2,name);
			
			int test= psUpdate.executeUpdate();
			if(test==1)
			return true;
		}
		catch (SQLException e) {

			Flash.affiche("Acces refusé ");
		}
		catch (IOException e) {
			Flash.affiche("erreur IO");
		}
		return false;
	}
}
