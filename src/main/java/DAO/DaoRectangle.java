package DAO;

import java.sql.Connection;

import Formes.Cercle;
import Formes.Rectangle;

public class DaoRectangle extends DAO_Figure<Rectangle> {

	public DaoRectangle(Connection connect) {
		super(connect);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Rectangle obj) {
		// TODO Auto-genera ted method stub
		return false;
	}

	@Override
	public Rectangle read(String name) {
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
