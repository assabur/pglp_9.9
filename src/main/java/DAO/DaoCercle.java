/**
 * 
 */
package DAO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;

import Formes.Cercle;
import fr.uvsq.solid.pglp_9.Flash;

/**
 * @author MAIGA
 *
 */
public class DaoCercle extends DAO_Figure<Cercle> {

	public DaoCercle(Connection connect) 
	{
		super(connect);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DAO.DAO_Figure#create(java.lang.Object, java.lang.String) meth
	 */
	@Override
	public boolean create(Cercle obj) {

		try {
			/*
			 * j'initialise ma requette preparé
			 */
			psInsert = conn.prepareStatement(SQL_SERIALIZE_OBJECT);
			statements.add(psInsert);
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
			psInsert.setString(1, obj.getname());
			psInsert.setBinaryStream(2, objectIn, b.length);
			Flash.affiche("avant insertion ");
			int test=psInsert.executeUpdate();
			if(test==-1)
			Flash.affiche("commande creer ");
			
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
	public Cercle read(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Cercle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String name) {
		// TODO Auto-generated method stub
		return false;
	}

}
