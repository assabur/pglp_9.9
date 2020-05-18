package DAO;

import java.sql.Connection;

import Formes.Triangle;

public class DaoTriangle extends DAO_Figure<Triangle> {

	public DaoTriangle(Connection conn) {
		// TODO Auto-generated constructor stub
		super(conn);
	}

	@Override
	public boolean create(Triangle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Triangle read(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Triangle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String name) {
		// TODO Auto-generated method stub
		return false;
	}

}
