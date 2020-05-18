/**
 * 
 */
package DAO;

import java.sql.Connection;

import Formes.Cercle;

/**
 * @author MAIGA
 *
 */
public class DaoCercle extends DAO_Figure<Cercle> {

	public DaoCercle(Connection connect) {
		super(connect);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */

	@Override
	public boolean create(Cercle obj) {
		// TODO Auto-generated method stub
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
