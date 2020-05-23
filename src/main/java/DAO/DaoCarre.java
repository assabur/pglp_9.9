package DAO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.SQLException;

import Formes.Carre;
import fr.uvsq.solid.pglp_9.Flash;

public class DaoCarre extends DAO_Figure<Carre>{

	public DaoCarre(Connection conn) {
		// TODO Auto-generated constructor stub
		super(conn);
	}

	@Override
	public boolean create(Carre obj) {
		Flash.affiche(obj.toString());
		try {
			/*
			 * j'initialise ma requette preparé
			 */
			
			psInsert = conn.prepareStatement(SQL_SERIALIZE_OBJECT);
				
			/*
			 * transformation de mon objet en flux de données
			 */
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(out);
			
			os.writeObject(obj);
			byte[] b = out.toByteArray();
			ByteArrayInputStream objectIn = new ByteArrayInputStream(b);

			/*
			 * j'effectue les insertions du nom de la variable et l'objet
			 */
			
			String nom=obj.getNom();
			psInsert.setString(1,nom);
			psInsert.setBinaryStream(2, objectIn, b.length);
			psInsert.executeUpdate();
			//System.out.println(objectIn);
			objectIn.close();
			os.flush();
			os.close();
			out.reset();
			out.close();
			return true;

		} catch (SQLException e) {
			Flash.affiche("erreur sql ");
		}
		catch (IOException e) {
			Flash.affiche("erreur IO");
		}
		
		
		
		return false;
	}

	@Override
	public Carre read(Object name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(String obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String name) {
		// TODO Auto-generated method stub
		return false;
	}

}
