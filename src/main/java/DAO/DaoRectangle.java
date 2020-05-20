package DAO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;

import Formes.Cercle;
import Formes.Rectangle;
import fr.uvsq.solid.pglp_9.Flash;

public class DaoRectangle extends DAO_Figure<Rectangle> {
	private String variable="";
	public DaoRectangle(Connection connect,String variable) {
		super(connect);
		this.variable=variable;
	}

	@Override
	public boolean create(Rectangle obj) {
		try {
			/*
			 * j'initialise ma requette preparé
			 */
			psInsert = conn.prepareStatement(SQL_SERIALIZE_OBJECT);
			//statements.add(psInsert);
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
			psInsert.setString(1, variable);
			psInsert.setBinaryStream(2, objectIn, b.length);

			psInsert.executeUpdate();
			System.out.println(objectIn);
			objectIn.close();
			os.flush();
			os.close();
			out.reset();
			out.close();
			return true;

		} catch (Exception e) {
			Flash.affiche("creation non valide ");
		}
		return false;
	}

	@Override
	public Rectangle read(Object name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Rectangle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
